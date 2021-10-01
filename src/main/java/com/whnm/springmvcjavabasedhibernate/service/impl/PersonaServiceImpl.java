package com.whnm.springmvcjavabasedhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whnm.springmvcjavabasedhibernate.dao.CRUDDAO;
import com.whnm.springmvcjavabasedhibernate.dao.PersonaDAO;
import com.whnm.springmvcjavabasedhibernate.entity.Persona;
import com.whnm.springmvcjavabasedhibernate.service.PersonaService;

@Service
public class PersonaServiceImpl extends CRUDServiceImpl<Persona> implements PersonaService{
	
	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public CRUDDAO<Persona> getDAO() {
		return personaDAO;
	}

}
