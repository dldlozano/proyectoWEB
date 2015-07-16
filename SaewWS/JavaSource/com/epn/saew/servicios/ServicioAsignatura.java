package com.epn.saew.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.saew.entidades.Asignatura;

@Stateless
public class ServicioAsignatura extends ServicioBase<Asignatura> { 
	public ServicioAsignatura(){
	}
	public ServicioAsignatura(Class<Asignatura> clase){
		super(clase);
	}
	@SuppressWarnings("unchecked")
	public List<Asignatura> buscarTodos() { 
		 return super.buscarTodos("Asignatura.findAll");
	}
}