package com.epn.moodle.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodo")
	private Integer idPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_periodo")
	private Date fechaFinPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_periodo")
	private Date fechaInicioPeriodo;

	@Column(name="nombre_periodo")
	private String nombrePeriodo;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="id_asignatura")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Periodo() {
	}

	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Date getFechaFinPeriodo() {
		return this.fechaFinPeriodo;
	}

	public void setFechaFinPeriodo(Date fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}

	public Date getFechaInicioPeriodo() {
		return this.fechaInicioPeriodo;
	}

	public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}

	public String getNombrePeriodo() {
		return this.nombrePeriodo;
	}

	public void setNombrePeriodo(String nombrePeriodo) {
		this.nombrePeriodo = nombrePeriodo;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}