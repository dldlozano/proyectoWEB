package com.epn.saew.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="apellidos_persona")
	private String apellidosPersona;

	@Column(name="cedula_persona")
	private String cedulaPersona;

	private String contrasenia;

	@Column(name="nombre_persona")
	private String nombrePersona;

	@Column(name="numero_unico")
	private String numeroUnico;

	//bi-directional many-to-one association to Periodo
	@OneToMany(mappedBy="persona")
	private List<Periodo> periodos;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public Persona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidosPersona() {
		return this.apellidosPersona;
	}

	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}

	public String getCedulaPersona() {
		return this.cedulaPersona;
	}

	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getNumeroUnico() {
		return this.numeroUnico;
	}

	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}

	public List<Periodo> getPeriodos() {
		return this.periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public Periodo addPeriodo(Periodo periodo) {
		getPeriodos().add(periodo);
		periodo.setPersona(this);

		return periodo;
	}

	public Periodo removePeriodo(Periodo periodo) {
		getPeriodos().remove(periodo);
		periodo.setPersona(null);

		return periodo;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}