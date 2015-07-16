package com.epn.moodle.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * http://stackoverflow.com/questions/3888575/single-dao-generic-crud-methods-jpa-hibernate-spring
 * http://www.ibm.com/developerworks/java/library/j-genericdao/index.html
 * http://www.adam-bien.com/roller/abien/entry/generic_crud_service_aka_dao
 * @author luis
 *
 * @param <T>
 */
public abstract class ServicioBase<T> {

	protected Class<T> clase;
	
	@PersistenceContext
	protected EntityManager em;
	
	public ServicioBase() {
	}
	
	public ServicioBase(Class<T> clase) {
		this.clase = clase;
	}
	
	public void insertar(T entidad){
		em.persist(entidad);
	}
	
	public void actualizar(T entidad){
		em.merge(entidad);
	}
	
	public void eliminar(T entidad){
		em.remove(em.merge(entidad));
	}
	
	public T buscarPorId(int id){
		return em.find(clase, id);
	}
	
	@SuppressWarnings("rawtypes")
	public List buscarTodos(String namedQuery){
		return em.createNamedQuery(namedQuery).getResultList();
	}
}
