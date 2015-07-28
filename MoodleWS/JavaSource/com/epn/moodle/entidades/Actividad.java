package com.epn.moodle.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_actividad")
	private Integer idActividad;

	@Column(name="calificacion_asignatura")
	private BigDecimal calificacionAsignatura;

	@Column(name="descripcion_actividad")
	private String descripcionActividad;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="valor_actividad")
	private BigDecimal valorActividad;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="id_asignatura")
	private Asignatura asignatura;

	public Actividad() {
	}

	public Integer getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public BigDecimal getCalificacionAsignatura() {
		return this.calificacionAsignatura;
	}

	public void setCalificacionAsignatura(BigDecimal calificacionAsignatura) {
		this.calificacionAsignatura = calificacionAsignatura;
	}

	public String getDescripcionActividad() {
		return this.descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public BigDecimal getValorActividad() {
		return this.valorActividad;
	}

	public void setValorActividad(BigDecimal valorActividad) {
		this.valorActividad = valorActividad;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

}