package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl  implements IMateriaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Materia buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery=this.entityManager.createQuery("Select m from Materia m where m.codigo=:valor",Materia.class);
		myQuery.setParameter("valor", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void create(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);

	}
	
	@Override
	public void update(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}
	
	

}
