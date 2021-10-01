package com.whnm.springmvcjavabasedhibernate.service;

import java.util.List;

public interface CRUDService<T> {
	public void registrar(T t) throws Exception;
	public void modificar(T t) throws Exception;
	public void eliminar(T t) throws Exception;
	public List<T> listarTodos() throws Exception;
	public T listarPorId(Integer id) throws Exception;
}
