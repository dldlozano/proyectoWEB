package com.epn.moodle.controladores;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.epn.moodle.entidades.Asignatura;
import com.epn.moodle.servicios.ServicioAsignatura;

@ManagedBean
@ViewScoped
public class AsignaturaControlador { 
	private Asignatura asignatura;
	private List<Asignatura> asignaturas;
	private int idAsignaturaSeleccionado;
	private boolean esActualizar;
	@EJB
	private ServicioAsignatura servAsignatura;
	public AsignaturaControlador(){
		asignaturas = new ArrayList<Asignatura>();
	}

	@PostConstruct
	public void init(){
		asignatura = new Asignatura();
		asignaturas = servAsignatura.buscarTodos();
	}
	public void insertar() {
		servAsignatura.insertar(asignatura);
		init();
		limpiar();
	}
	public void actualizar() {
		servAsignatura.actualizar(asignatura);
		init();
		limpiar();
	}
	public void eliminar() {
		servAsignatura.eliminar(asignatura);
		init();
		limpiar();
	}
	public void limpiar() {
		asignatura = new Asignatura();
	}

	//getters y setters
	public Asignatura getAsignatura (){
		return asignatura;
	}

	public void setAsignatura (Asignatura asignatura){
		this.asignatura=asignatura;
	}

	public List<Asignatura> getAsignaturas (){
		return asignaturas;
	}

	public void setAsignatura (List<Asignatura> asignaturas){
		this.asignaturas=asignaturas;
	}

	public int getIdAsignaturaSeleccionado(){
		return idAsignaturaSeleccionado;
	}

	public void setIdAsignaturaSeleccionado (int idAsignaturaSeleccionado){
		this.idAsignaturaSeleccionado=idAsignaturaSeleccionado;
	}

	public boolean isEsActualizaresActualizar (){
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar){
		this.esActualizar=esActualizar;
	}
}