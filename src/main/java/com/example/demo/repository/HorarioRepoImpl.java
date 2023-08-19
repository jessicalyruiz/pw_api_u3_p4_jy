package com.example.demo.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.model.Horario;

@Repository
@Transactional
public class HorarioRepoImpl  implements IHorarioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Horario buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery=this.entityManager.createQuery("Select e from Horario e where e.codigo=:valor",Horario.class);
		myQuery.setParameter("valor", codigo);
		return myQuery.getSingleResult(); 
	}

	@Override
	public void create(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public Horario read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public void update(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public void partialUpdate(String codigoActual, String codigoNueva) {
		// TODO Auto-generated method stub
		/*Query myQuery=this.entityManager.createQuery("UPDATE Horario e SET e.codigo=:datoCodigo WHERE e.codigo=:datoCondicion");
		myQuery.setParameter("datoCodigo", codigoNueva);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();*/
	}

	@Override
	public List<Horario> buscarTodos() {
		TypedQuery<Horario> myQuery=this.entityManager.createQuery("Select e from Horario e", Horario.class);
		
		return myQuery.getResultList();
	}


	

}
