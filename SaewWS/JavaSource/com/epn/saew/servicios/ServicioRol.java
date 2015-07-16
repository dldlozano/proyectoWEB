package com.epn.saew.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.saew.entidades.Rol;

@Stateless
public class ServicioRol extends ServicioBase<Rol> { 
	public ServicioRol(){
	}
	public ServicioRol(Class<Rol> clase){
		super(clase);
	}
	@SuppressWarnings("unchecked")
	public List<Rol> buscarTodos() { 
		 return super.buscarTodos("Rol.findAll");
	}
}