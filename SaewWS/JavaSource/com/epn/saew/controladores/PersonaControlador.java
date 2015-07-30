package com.epn.saew.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.epn.saew.entidades.Persona;
import com.epn.saew.entidades.Rol;
import com.epn.saew.servicios.ServicioPersona;
import com.epn.saew.servicios.ServicioRol;

@ManagedBean
@ViewScoped
public class PersonaControlador {
	private Persona persona;
	private List<Persona> personas;
	private int idPersonaSeleccionado;
	private boolean esActualizar;

	private Rol rol;
	private List<Rol> roles;
	private int indexRolSeleccionado;

	@EJB
	private ServicioPersona servPersona;
	@EJB
	private ServicioRol servRol;

	public PersonaControlador() {
		personas = new ArrayList<Persona>();
	}

	@PostConstruct
	public void init() {
		persona = new Persona();
		personas = servPersona.buscarTodos();
		roles = servRol.buscarTodos();
	}

	public void insertar() {
		rol = roles.get(indexRolSeleccionado-1);
		persona.setRol(rol);
		servPersona.insertar(persona);
		init();
	}

	public void actualizar() {
		servPersona.actualizar(persona);
		init();
	}

	public void eliminar() {
		servPersona.eliminar(persona);
		init();
	}
	
	public void limpiar(){
		persona = new Persona();
	}

	// getters y setters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersona(List<Persona> personas) {
		this.personas = personas;
	}

	public int getIdPersonaSeleccionado() {
		return idPersonaSeleccionado;
	}

	public void setIdPersonaSeleccionado(int idPersonaSeleccionado) {
		this.idPersonaSeleccionado = idPersonaSeleccionado;
	}

	public boolean isesActualizar() {
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar) {
		this.esActualizar = esActualizar;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public int getIndexRolSeleccionado() {
		return indexRolSeleccionado;
	}

	public void setIndexRolSeleccionado(int indexRolSeleccionado) {
		this.indexRolSeleccionado = indexRolSeleccionado;
	}
}