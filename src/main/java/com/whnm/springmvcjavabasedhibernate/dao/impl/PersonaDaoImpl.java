package com.whnm.springmvcjavabasedhibernate.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whnm.springmvcjavabasedhibernate.dao.AbstractDAO;
import com.whnm.springmvcjavabasedhibernate.dao.PersonaDAO;
import com.whnm.springmvcjavabasedhibernate.entity.Persona;

@Repository
@Transactional
public class PersonaDaoImpl extends AbstractDAO implements PersonaDAO {

	@Override
	public void registrar(Persona persona) throws Exception {
		persist(persona);
	}

	@Override
	public void modificar(Persona persona) throws Exception {
		update(persona);
	}

	@Override
	public void eliminar(Persona persona) throws Exception {
		delete(persona);
	}

	@Override
	public List<Persona> listarTodos() throws Exception {
//		deprecated por rendimiento		
//		Criteria criteria = getSession().createCriteria(Persona.class);
//		return (List<Persona>)criteria.list();

//		forma 1		
//		CriteriaBuilder cb = getSession().getCriteriaBuilder();
//		CriteriaQuery<Persona> cr = cb.createQuery(Persona.class);
//		Root<Persona> root = cr.from(Persona.class);
//		cr.select(root);
//
//		Query<Persona> query = getSession().createQuery(cr);
//		List<Persona> results = query.getResultList();
		
//		forma2
		TypedQuery<Persona> query = getSession().createQuery("from Persona");
		return query.getResultList();
	}

	@Override
	public Persona listarPorId(Integer id) throws Exception {
		List<Persona> lista;
		String hql = "FROM Persona WHERE id = :id";
//		forma 1
//		Query<Persona> query = getSession().createQuery(hql);

//		forma 2		
		TypedQuery<Persona> query = getSession().createQuery(hql);
		query.setParameter("id", id);
		
		lista = (List<Persona>)query.getResultList();
		Persona persona = lista != null && !lista.isEmpty() ? lista.get(0) : new Persona();
		return persona;
	}

}
