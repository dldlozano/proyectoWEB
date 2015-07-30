package com.epn.saew.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.epn.saew.entidades.Asignatura;
import com.epn.saew.entidades.Periodo;
import com.epn.saew.entidades.Persona;
import com.epn.saew.rest.entidades.Curso;
import com.epn.saew.servicios.ServicioAsignatura;
import com.epn.saew.servicios.ServicioPeriodo;
import com.epn.saew.servicios.ServicioPersona;
import com.epn.saew.servicios.ServicioWS;

@ManagedBean
@ViewScoped
public class MisCursosCtrl {

	private List<Asignatura>asignaturas;
	private List<Periodo>periodos;
	private int idPeriodoSeleccionado;
	private Periodo periodo;
	private List<Persona>estudiantes;
	
	@EJB
	private ServicioAsignatura servAsignatura;
	@EJB
	private ServicioPeriodo servPeriodo;
	@EJB
	private ServicioPersona serPersona;
	@EJB
	private ServicioWS servWS;
	
	public MisCursosCtrl() {
		periodos = new ArrayList<Periodo>();
		asignaturas = new ArrayList<Asignatura>();
		estudiantes = new ArrayList<Persona>();
	}
	
	@PostConstruct
	public void init(){
		periodos= servPeriodo.buscarTodos();
	}
	
	public void seleccionarPeriodo(){
		for(Periodo p : periodos){
			if(p.getIdPeriodo()==idPeriodoSeleccionado){
				periodo = p;
				break;
			}
		}
		asignaturas.add(periodo.getAsignatura());
	}
	
	public void seleccionarEstudiante(){
		List<Persona>tmp= serPersona.buscarTodos();
		for(Persona e:tmp){
			if(e.getRol().getNombreRol().equals("Estudiante"))
				estudiantes.add(e);
		}
		
	}
	
	public void matricularEstudiantesMoodle(){
		Curso curso = new Curso();
		curso.setAlumnos(estudiantes);
		curso.setProfesor(serPersona.buscarPorId(3));
		curso.setPeriodo(periodo);
		servWS.solicitarWS(curso);
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public int getIdPeriodoSeleccionado() {
		return idPeriodoSeleccionado;
	}

	public void setIdPeriodoSeleccionado(int idPeriodoSeleccionado) {
		this.idPeriodoSeleccionado = idPeriodoSeleccionado;
	}

	public List<Persona> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Persona> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
}

