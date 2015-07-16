package com.epn.moodle.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.moodle.entidades.Actividad;

@Stateless
public class ServicioActividad extends ServicioBase<Actividad> { 
	public ServicioActividad(){
	}
	public ServicioActividad(Class<Actividad> clase){
		super(clase);
	}
	@SuppressWarnings("unchecked")
	public List<Actividad> buscarTodos() { 
		 return super.buscarTodos("Actividad.findAll");
	}
}