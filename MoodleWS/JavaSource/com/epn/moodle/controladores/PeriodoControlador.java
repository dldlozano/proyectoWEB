package com.epn.moodle.controladores;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.epn.moodle.entidades.Periodo;
import com.epn.moodle.servicios.ServicioPeriodo;

@ManagedBean
@ViewScoped
public class PeriodoControlador { 
	private Periodo periodo;
	private List<Periodo> periodos;
	private int idPeriodoSeleccionado;
	private boolean esActualizar;
	@EJB
	private ServicioPeriodo servPeriodo;
	public PeriodoControlador(){
		periodos = new ArrayList<Periodo>();
	}

	@PostConstruct
	public void init(){
		periodo = new Periodo();
		periodos = servPeriodo.buscarTodos();
	}
	public void insertar() {
		servPeriodo.insertar(periodo);
		init();
		limpiar();
	}
	public void actualizar() {
		servPeriodo.actualizar(periodo);
		init();
		limpiar();
	}
	public void eliminar() {
		servPeriodo.eliminar(periodo);
		init();
		limpiar();
	}
	public void limpiar() {
		periodo = new Periodo();
	}

	//getters y setters
	public Periodo getPeriodo (){
		return periodo;
	}

	public void setPeriodo (Periodo periodo){
		this.periodo=periodo;
	}

	public List<Periodo> getPeriodos (){
		return periodos;
	}

	public void setPeriodo (List<Periodo> periodos){
		this.periodos=periodos;
	}

	public int getIdPeriodoSeleccionado(){
		return idPeriodoSeleccionado;
	}

	public void setIdPeriodoSeleccionado (int idPeriodoSeleccionado){
		this.idPeriodoSeleccionado=idPeriodoSeleccionado;
	}

	public boolean isEsActualizaresActualizar (){
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar){
		this.esActualizar=esActualizar;
	}
}