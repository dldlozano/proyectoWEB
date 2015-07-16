package com.epn.saew.controladores;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.epn.saew.entidades.Persona;
import com.epn.saew.servicios.ServicioPersona;

@ManagedBean
@ViewScoped
public class PersonaControlador { 
	private Persona persona;
	private List<Persona> personas;
	private int idPersonaSeleccionado;
	private boolean esActualizar;
	@EJB
	private ServicioPersona servPersona;
	public PersonaControlador(){
		personas = new ArrayList<Persona>();
	}

	@PostConstruct
	public void init(){
		persona = new Persona();
		personas = servPersona.buscarTodos();
	}
	public void insertar() {
		servPersona.insertar(persona);
		init();
		limpiar();
	}
	public void actualizar() {
		servPersona.actualizar(persona);
		init();
		limpiar();
	}
	public void eliminar() {
		servPersona.eliminar(persona);
		init();
		limpiar();
	}
	public void limpiar() {
		persona = new Persona();
	}

	//getters y setters
	public Persona getPersona (){
		return persona;
	}

	public void setPersona (Persona persona){
		this.persona=persona;
	}

	public List<Persona> getPersonas (){
		return personas;
	}

	public void setPersona (List<Persona> personas){
		this.personas=personas;
	}

	public int getIdPersonaSeleccionado(){
		return idPersonaSeleccionado;
	}

	public void setIdPersonaSeleccionado (int idPersonaSeleccionado){
		this.idPersonaSeleccionado=idPersonaSeleccionado;
	}

	public boolean isesActualizar (){
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar){
		this.esActualizar=esActualizar;
	}
}