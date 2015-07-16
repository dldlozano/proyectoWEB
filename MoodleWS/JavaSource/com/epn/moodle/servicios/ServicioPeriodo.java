package com.epn.moodle.servicios;
import java.util.List;
import javax.ejb.Stateless;
import com.epn.moodle.entidades.Periodo;

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
}