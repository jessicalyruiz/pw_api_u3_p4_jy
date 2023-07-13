package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

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
		return null;
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
	

}
