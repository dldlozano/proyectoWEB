package com.epn.saew.servicios;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

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
	
	@Override
	public Persona buscarPorId(int id) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select p from Persona p where p.idPersona= :paramId");
		q.setParameter("paramId", id);
		return (Persona) q.getSingleResult();
	}
}