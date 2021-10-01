package com.whnm.springmvcjavabasedhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whnm.springmvcjavabasedhibernate.dao.CRUDDAO;
import com.whnm.springmvcjavabasedhibernate.dao.TelefonoDAO;
import com.whnm.springmvcjavabasedhibernate.entity.Telefono;
import com.whnm.springmvcjavabasedhibernate.service.TelefonoService;

@Service
public class TelefonoServiceImpl extends CRUDServiceImpl<Telefono> implements TelefonoService{
	
	@Autowired
	private TelefonoDAO telefonoDAO;

	@Override
	public CRUDDAO<Telefono> getDAO() {
		return telefonoDAO;
	}
		
}
