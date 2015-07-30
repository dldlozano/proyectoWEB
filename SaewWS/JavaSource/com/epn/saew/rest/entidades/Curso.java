package com.epn.saew.rest.entidades;

import java.util.List;

import com.epn.saew.entidades.Periodo;
import com.epn.saew.entidades.Persona;

public class Curso {

	private Persona profesor;
	private List<Persona>alumnos;
	private Periodo periodo;
	
	
	public Persona getProfesor() {
		return profesor;
	}
	public void setProfesor(Persona profesor) {
		this.profesor = profesor;
	}
	public List<Persona> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Persona> alumnos) {
		this.alumnos = alumnos;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
}
