package com.whnm.springmvcjavabasedhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.whnm.springmvcjavabasedhibernate.entity.Telefono;
import com.whnm.springmvcjavabasedhibernate.service.PersonaService;
import com.whnm.springmvcjavabasedhibernate.service.TelefonoService;

@Controller
@RequestMapping()
public class TelefonoController {
	
	@Autowired
	private TelefonoService telefonoService;

	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/irTelefono", method = RequestMethod.GET)
	public ModelAndView redireccion() throws Exception {
		ModelAndView model = new ModelAndView("telefono");
		model.addObject("personas", personaService.listarTodos());
		model.addObject("command", new Telefono());
		return model;
	}

	@RequestMapping(value = "/registrarTelefono", method = RequestMethod.POST)
	public ModelAndView registrar(Telefono telefono, ModelMap model) throws Exception {
		telefonoService.registrar(telefono);
		return new ModelAndView("listaPersonas", "personas", personaService.listarTodos());
	}
}
