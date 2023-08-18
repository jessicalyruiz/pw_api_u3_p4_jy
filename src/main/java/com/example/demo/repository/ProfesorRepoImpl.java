package com.example.demo.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.model.Profesor;

@Repository
@Transactional
public class ProfesorRepoImpl  implements IProfesorRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Profesor buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Profesor> myQuery=this.entityManager.createQuery("Select e from Profesor e where e.cedula=:valor",Profesor.class);
		myQuery.setParameter("valor", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void create(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(profesor);
	}

	@Override
	public Profesor read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void update(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(profesor);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public void partialUpdate(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE Profesor e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCondicion", cedulaActual);
		myQuery.executeUpdate();
	}

	@Override
	public List<Profesor> buscarTodos() {
		TypedQuery<Profesor> myQuery=this.entityManager.createQuery("Select e from Profesor e", Profesor.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Profesor> buscarCategoria(String categoria) {
TypedQuery<Profesor> myQuery=this.entityManager.createQuery("Select e from Profesor e where e.provincia=:valor", Profesor.class);
		myQuery.setParameter("valor", categoria);
		return myQuery.getResultList();
	}
	

}
