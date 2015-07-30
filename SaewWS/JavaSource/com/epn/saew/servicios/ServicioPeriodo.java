package com.epn.saew.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.saew.entidades.Periodo;

@Stateless
public class ServicioPeriodo extends ServicioBase<Periodo> { 
	public ServicioPeriodo(){
	}
	public ServicioPeriodo(Class<Periodo> clase){
		super(clase);
	}
	@SuppressWarnings("unchecked")
	public List<Periodo> buscarTodos() { 
		 return super.buscarTodos("Periodo.findAll");
	}
	
	public void registrarNotas(){
		
	}
}