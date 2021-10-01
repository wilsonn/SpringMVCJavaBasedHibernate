package com.whnm.springmvcjavabasedhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(Object entidad) {
		getSession().persist(entidad);
	}
	
	public void update(Object entidad) {
		getSession().update(entidad);
	}
	
	public void delete(Object entidad) {
		getSession().delete(entidad);
	}
}
