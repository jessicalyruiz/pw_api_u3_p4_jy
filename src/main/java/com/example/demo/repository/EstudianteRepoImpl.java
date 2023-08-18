package com.example.demo.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.model.Estudiante;

@Repository
@Transactional
public class EstudianteRepoImpl  implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("Select e from Estudiante e where e.cedula=:valor",Estudiante.class);
		myQuery.setParameter("valor", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void create(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public void partialUpdate(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE Estudiante e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCondicion", cedulaActual);
		myQuery.executeUpdate();
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("Select e from Estudiante e", Estudiante.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarProvincia(String provincia) {
TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("Select e from Estudiante e where e.provincia=:valor", Estudiante.class);
		myQuery.setParameter("valor", provincia);
		return myQuery.getResultList();
	}
	

}
