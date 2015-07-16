package com.epn.moodle.entidades;

// Generated 16/07/2015 13:52:11 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Actividad generated by hbm2java
 */
@Entity
@Table(name = "actividad", schema = "public")
public class Actividad implements java.io.Serializable {

	private int idActividad;
	private Asignatura asignatura;
	private String nombreActividad;
	private String descripcionActividad;
	private BigDecimal calificacionAsignatura;

	public Actividad() {
	}

	public Actividad(int idActividad, String nombreActividad,
			String descripcionActividad, BigDecimal calificacionAsignatura) {
		this.idActividad = idActividad;
		this.nombreActividad = nombreActividad;
		this.descripcionActividad = descripcionActividad;
		this.calificacionAsignatura = calificacionAsignatura;
	}

	public Actividad(int idActividad, Asignatura asignatura,
			String nombreActividad, String descripcionActividad,
			BigDecimal calificacionAsignatura) {
		this.idActividad = idActividad;
		this.asignatura = asignatura;
		this.nombreActividad = nombreActividad;
		this.descripcionActividad = descripcionActividad;
		this.calificacionAsignatura = calificacionAsignatura;
	}

	@Id
	@Column(name = "id_actividad", unique = true, nullable = false)
	public int getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_asignatura")
	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Column(name = "nombre_actividad", nullable = false, length = 100)
	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	@Column(name = "descripcion_actividad", nullable = false, length = 500)
	public String getDescripcionActividad() {
		return this.descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	@Column(name = "calificacion_asignatura", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getCalificacionAsignatura() {
		return this.calificacionAsignatura;
	}

	public void setCalificacionAsignatura(BigDecimal calificacionAsignatura) {
		this.calificacionAsignatura = calificacionAsignatura;
	}

}