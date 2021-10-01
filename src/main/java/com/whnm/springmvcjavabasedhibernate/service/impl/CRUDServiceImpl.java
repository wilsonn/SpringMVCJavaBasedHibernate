package com.whnm.springmvcjavabasedhibernate.service.impl;

import java.util.List;

import com.whnm.springmvcjavabasedhibernate.dao.CRUDDAO;
import com.whnm.springmvcjavabasedhibernate.service.CRUDService;

public abstract class CRUDServiceImpl<T> implements CRUDService<T>{
	
	public abstract CRUDDAO<T> getDAO();
	
	@Override
	public void registrar(T t) throws Exception {
		getDAO().registrar(t);
	}

	@Override
	public void modificar(T t) throws Exception {
		getDAO().modificar(t);
	}

	@Override
	public void eliminar(T t) throws Exception {
		getDAO().eliminar(t);
	}

	@Override
	public List<T> listarTodos() throws Exception {
		return getDAO().listarTodos();
	}

	@Override
	public T listarPorId(Integer id) throws Exception {
		return getDAO().listarPorId(id);
	}
}
