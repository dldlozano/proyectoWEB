package com.epn.moodle.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the asignatura database table.
 * 
 */
@Entity
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignatura")
	private Integer idAsignatura;

	@Column(name="calificacion_dos_asignatura")
	private BigDecimal calificacionDosAsignatura;

	@Column(name="calificacion_tres_asignatura")
	private BigDecimal calificacionTresAsignatura;

	@Column(name="calificacion_uno_asignatura")
	private BigDecimal calificacionUnoAsignatura;

	@Column(name="descripcion_asignatura")
	private String descripcionAsignatura;

	private String grupo;

	@Column(name="nombre_asignatura")
	private String nombreAsignatura;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="asignatura")
	private List<Actividad> actividads;

	//bi-directional many-to-one association to Periodo
	@OneToMany(mappedBy="asignatura")
	private List<Periodo> periodos;

	public Asignatura() {
	}

	public Integer getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public BigDecimal getCalificacionDosAsignatura() {
		return this.calificacionDosAsignatura;
	}

	public void setCalificacionDosAsignatura(BigDecimal calificacionDosAsignatura) {
		this.calificacionDosAsignatura = calificacionDosAsignatura;
	}

	public BigDecimal getCalificacionTresAsignatura() {
		return this.calificacionTresAsignatura;
	}

	public void setCalificacionTresAsignatura(BigDecimal calificacionTresAsignatura) {
		this.calificacionTresAsignatura = calificacionTresAsignatura;
	}

	public BigDecimal getCalificacionUnoAsignatura() {
		return this.calificacionUnoAsignatura;
	}

	public void setCalificacionUnoAsignatura(BigDecimal calificacionUnoAsignatura) {
		this.calificacionUnoAsignatura = calificacionUnoAsignatura;
	}

	public String getDescripcionAsignatura() {
		return this.descripcionAsignatura;
	}

	public void setDescripcionAsignatura(String descripcionAsignatura) {
		this.descripcionAsignatura = descripcionAsignatura;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNombreAsignatura() {
		return this.nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public List<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividads().add(actividad);
		actividad.setAsignatura(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividads().remove(actividad);
		actividad.setAsignatura(null);

		return actividad;
	}

	public List<Periodo> getPeriodos() {
		return this.periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public Periodo addPeriodo(Periodo periodo) {
		getPeriodos().add(periodo);
		periodo.setAsignatura(this);

		return periodo;
	}

	public Periodo removePeriodo(Periodo periodo) {
		getPeriodos().remove(periodo);
		periodo.setAsignatura(null);

		return periodo;
	}

}