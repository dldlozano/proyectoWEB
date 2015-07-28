package com.epn.saew.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Integer idRol;

	@Column(name="nombre_rol")
	private String nombreRol;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="rol")
	private List<Persona> personas;

	public Rol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setRol(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setRol(null);

		return persona;
	}

}