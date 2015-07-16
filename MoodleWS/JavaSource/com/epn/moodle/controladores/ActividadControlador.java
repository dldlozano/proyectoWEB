package com.epn.moodle.controladores;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.epn.moodle.entidades.Actividad;
import com.epn.moodle.servicios.ServicioActividad;

@ManagedBean
@ViewScoped
public class ActividadControlador { 
	private Actividad actividad;
	private List<Actividad> actividads;
	private int idActividadSeleccionado;
	private boolean esActualizar;
	@EJB
	private ServicioActividad servActividad;
	public ActividadControlador(){
		actividads = new ArrayList<Actividad>();
	}

	@PostConstruct
	public void init(){
		actividad = new Actividad();
		actividads = servActividad.buscarTodos();
	}
	public void insertar() {
		servActividad.insertar(actividad);
		init();
		limpiar();
	}
	public void actualizar() {
		servActividad.actualizar(actividad);
		init();
		limpiar();
	}
	public void eliminar() {
		servActividad.eliminar(actividad);
		init();
		limpiar();
	}
	public void limpiar() {
		actividad = new Actividad();
	}

	//getters y setters
	public Actividad getActividad (){
		return actividad;
	}

	public void setActividad (Actividad actividad){
		this.actividad=actividad;
	}

	public List<Actividad> getActividads (){
		return actividads;
	}

	public void setActividad (List<Actividad> actividads){
		this.actividads=actividads;
	}

	public int getIdActividadSeleccionado(){
		return idActividadSeleccionado;
	}

	public void setIdActividadSeleccionado (int idActividadSeleccionado){
		this.idActividadSeleccionado=idActividadSeleccionado;
	}

	public boolean isEsActualizar (){
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar){
		this.esActualizar=esActualizar;
	}
}