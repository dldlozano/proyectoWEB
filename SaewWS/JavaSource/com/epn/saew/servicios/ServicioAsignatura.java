package com.epn.saew.servicios;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

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
	public List<Asignatura> buscarMisCursos(int idPeriodo) {
		Query q = em
				.createQuery("select a from Asignatura a where id.periodo.idPeriodo = :paramPeriodo");
		q.setParameter("paramPeriodo", idPeriodo);
		return q.getResultList();
	}
}