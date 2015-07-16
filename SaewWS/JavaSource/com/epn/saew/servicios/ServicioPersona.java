package com.epn.saew.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.saew.entidades.Persona;

@Stateless
public class ServicioPersona extends ServicioBase<Persona> { 
	public ServicioPersona(){
	}
	public ServicioPersona(Class<Persona> clase){
		super(clase);
	}
	@SuppressWarnings("unchecked")
	public List<Persona> buscarTodos() { 
		 return super.buscarTodos("Persona.findAll");
	}
}