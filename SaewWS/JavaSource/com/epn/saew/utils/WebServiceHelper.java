package com.epn.saew.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

/**
 * Fuente:
 * http://ihofmann.wordpress.com/2012/08/09/restful-web-services-with-json-in-
 * android/
 * 
 * Encargado de la conexión hacia web services
 * 
 * Ampliada la funcionalidad para GET y POST con manejo de retornos dinamicos
 * usando genericos y GSON como libreria de Marshall Unmarshall. CG
 * 
 * @author Ingo Hofmann
 * @author Christian Guevara
 * 
 */
public class WebServiceHelper<E> {
	private static int CONNECTION_TIMEOUT = 2000;
	private static int DATARETRIEVAL_TIMEOUT = 5000;
	private StringBuilder tipoTrama;

	/**
	 * Creara una instancia con el tipo de trama por defecto (json)
	 */
	public WebServiceHelper() {
		super();
		System.out.println("WSHelperHelper"+ "Entro al constructor de WebServiceHelper");
		this.tipoTrama = new StringBuilder("application/json");
	}

	/**
	 * Creara una instancia con el tipo de trama que recibe como parametro
	 * 
	 * @param tipoTrama
	 *            Tipo de trama que manejara (json, xml, etc)
	 */
	public WebServiceHelper(String tipoTrama) {
		this.tipoTrama = new StringBuilder(tipoTrama);
	}

	public E requestWebServiceGET(String urlServicio, E obj) {
		return requestWebService(urlServicio, false, true, obj);
	}

	public E requestWebServicePOST(String urlServicio,
			boolean recibirRespuesta, E obj) {
		return requestWebService(urlServicio, true, recibirRespuesta, obj);
	}

	private E requestWebService(String urlServicio, boolean enviar,
			boolean recibirRespuesta, E obj) {
		//disableConnectionReuseIfNecessary();

		HttpURLConnection urlConnection = null;
		try {
			// Se Crea la connexión con los parametros para envio y recepción
			URL urlToRequest = new URL(urlServicio);
			urlConnection = (HttpURLConnection) urlToRequest.openConnection();
			urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
			urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
			urlConnection.setDoOutput(enviar);
			urlConnection.setDoInput(recibirRespuesta);
			// Si se puede enviar entonces la petición sera POST
			urlConnection.setRequestMethod(enviar ? "POST" : "GET");
			// Se usara Json por defecto
			urlConnection.setRequestProperty("Authorization",
					"key=AIzaSyCEFNxXPtIjJFmThuExX_2LgPa6YFu9RAo");
			if (enviar && recibirRespuesta) {
				urlConnection.setRequestProperty("Content-Type",
						tipoTrama.toString());
				urlConnection
						.setRequestProperty("Accept", tipoTrama.toString());
			} else if (enviar) {
				urlConnection.setRequestProperty("Content-Type",
						tipoTrama.toString());
			} else if (recibirRespuesta) {
				urlConnection
						.setRequestProperty("Accept", tipoTrama.toString());
			} else {
				System.out.println("WSHelper"+
						"Los valores de enviar y recibir no pueden ser nulos");
				return null;
			}

			// Crea una instancia de GSON para poder realizar las conversiones
			// Gson gson = new GsonBuilder().registerType(Date.class,
			// new JsonDateSerializer()).create();
			GsonBuilder gsonBuilder = new GsonBuilder();
			// Formato para las fechas a ser enviadas para interoperabilidad
			gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

			// Nuestro web service retorna las fechas como LONG, Gson por
			// defecto no las puede parsear asi que creamos nuestro propio
			// Deserializer
			gsonBuilder.registerTypeAdapter(Date.class,
					new JsonDeserializer<Date>() {
						public Date deserialize(JsonElement json, Type typeOfT,
								JsonDeserializationContext context)
								throws JsonParseException {
							return new Date(json.getAsJsonPrimitive()
									.getAsLong());
						}
					});

			Gson gson = gsonBuilder.create();
			// Crea el Stream para enviar el objeto
			if (enviar) {
				OutputStreamWriter writer = new OutputStreamWriter(
						urlConnection.getOutputStream());
				writer.write(gson.toJson(((E) obj)));
				writer.close();
			}

			// Manejar los mensajes de respuesta
			int statusCode = urlConnection.getResponseCode();
			System.out.println("WSHelper"+ "Status Code: " + statusCode);
			if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
				// Unauthorized (en caso de requerir autenticacion)
			} else if (statusCode != HttpURLConnection.HTTP_OK) {
				// TODO: Manejar los errores, 404, 500,..
				return null;
			}

			// Para cuando la respuesta es 200
			// Crea el Stream para recibir un objeto
			if (recibirRespuesta) {
				// Crear un objeto de acuerdo al retorno de la petición
				InputStreamReader is = new InputStreamReader(
						urlConnection.getInputStream());

				E objRespuesta = (E) gson.fromJson(is, obj.getClass());
				System.out.println("WSHelper"+ "Respuesta WS en objeto: " + objRespuesta);
				is.close();
				return objRespuesta;
			}
		} catch (ClassCastException ex) {
			// Error en la conversión de objetos
			ex.printStackTrace();
		} catch (MalformedURLException e) {
			// URL is invalid
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			// data retrieval or connection timed out
			e.printStackTrace();
		} catch (IOException e) {
			// could not read response body
			// (could not create input stream)

			// } catch (JSONException e) {
			// response body is no valid JSON string
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// response body is no valid JSON string
			e.printStackTrace();
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
		return null;
	}

	/**
	 * Required in order to prevent issues in earlier Android version.
	 */
//	private void disableConnectionReuseIfNecessary() {
//		// see HttpURLConnection API doc
//		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) {
//			System.setProperty("http.keepAlive", "false");
//		}
//	}

	private String getResponseText(InputStream inStream) {
		// very nice trick from
		// http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
		return new Scanner(inStream).useDelimiter("\\A").next();
	}
}