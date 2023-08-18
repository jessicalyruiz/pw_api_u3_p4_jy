package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.model.Materia;

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

	@Override
	public List<Materia> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery=this.entityManager.createQuery("Select m from Materia m where m.estudiante.cedula=:valor",Materia.class);
		myQuery.setParameter("valor", cedula);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Materia> buscarTodos() {
TypedQuery<Materia> myQuery=this.entityManager.createQuery("Select e from Materia e", Materia.class);
		
		return myQuery.getResultList();
	}
	
	

}
