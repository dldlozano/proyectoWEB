package com.epn.saew.servicios;

import javax.ejb.Stateless;

import com.epn.saew.rest.entidades.Curso;
import com.epn.saew.utils.WebServiceHelper;

@Stateless
public class ServicioWS {

	public boolean solicitarWS(Curso curso) {
		WebServiceHelper<Curso> helper = new WebServiceHelper<Curso>("application/json");
		Curso resp = helper.requestWebServicePOST("http://172.31.103.90:8085/MoodleWS/rest/matriculacion/matricular", true, curso);
		if (resp!=null) {
			return true;
		} else {
			return false;
		}
	}
}
