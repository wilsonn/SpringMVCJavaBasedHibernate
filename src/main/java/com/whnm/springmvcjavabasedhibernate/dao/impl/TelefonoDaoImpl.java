package com.whnm.springmvcjavabasedhibernate.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whnm.springmvcjavabasedhibernate.dao.AbstractDAO;
import com.whnm.springmvcjavabasedhibernate.dao.TelefonoDAO;
import com.whnm.springmvcjavabasedhibernate.entity.Telefono;

@Repository
@Transactional
public class TelefonoDaoImpl extends AbstractDAO implements TelefonoDAO {

	@Override
	public void registrar(Telefono t) throws Exception {
		persist(t);
	}

	@Override
	public void modificar(Telefono t) throws Exception {
		update(t);
	}

	@Override
	public void eliminar(Telefono t) throws Exception {
		delete(t);
	}

	@Override
	public List<Telefono> listarTodos() throws Exception {
		CriteriaBuilder cb = getSession().getCriteriaBuilder();
		CriteriaQuery<Telefono> cr = cb.createQuery(Telefono.class);
		Root<Telefono> root = cr.from(Telefono.class);
		cr.select(root);

		Query<Telefono> query = getSession().createQuery(cr);
		List<Telefono> results = query.getResultList();
		
		return results;
	}

	@Override
	public Telefono listarPorId(Integer id) throws Exception {
		List<Telefono> lista;
		String hql = "FROM Telefono WHERE id = :id";
		Query<Telefono> query = getSession().createQuery(hql);
		query.setParameter("id", id);
		
		lista = (List<Telefono>)query.getResultList();
		Telefono telefono = lista != null && !lista.isEmpty() ? lista.get(0) : new Telefono();
		return telefono;
	}

	

}
