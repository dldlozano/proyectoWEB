package com.epn.saew.controladores;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.epn.saew.entidades.Rol;
import com.epn.saew.servicios.ServicioRol;

@ManagedBean
@ViewScoped
public class RolControlador { 
	private Rol rol;
	private List<Rol> rols;
	private int idRolSeleccionado;
	private boolean esActualizar;
	@EJB
	private ServicioRol servRol;
	public RolControlador(){
		rols = new ArrayList<Rol>();
	}

	@PostConstruct
	public void init(){
		rol = new Rol();
		rols = servRol.buscarTodos();
	}
	public void insertar() {
		servRol.insertar(rol);
		init();
		limpiar();
	}
	public void actualizar() {
		servRol.actualizar(rol);
		init();
		limpiar();
	}
	public void eliminar() {
		servRol.eliminar(rol);
		init();
		limpiar();
	}
	public void limpiar() {
		rol = new Rol();
	}

	//getters y setters
	public Rol getRol (){
		return rol;
	}

	public void setRol (Rol rol){
		this.rol=rol;
	}

	public List<Rol> getRols (){
		return rols;
	}

	public void setRol (List<Rol> rols){
		this.rols=rols;
	}

	public int getIdRolSeleccionado(){
		return idRolSeleccionado;
	}

	public void setIdRolSeleccionado (int idRolSeleccionado){
		this.idRolSeleccionado=idRolSeleccionado;
	}

	public boolean isesActualizar (){
		return esActualizar;
	}

	public void setEsActualizar(boolean esActualizar){
		this.esActualizar=esActualizar;
	}
}