package com.whnm.springmvcjavabasedhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.whnm.springmvcjavabasedhibernate.entity.Persona;
import com.whnm.springmvcjavabasedhibernate.service.PersonaService;

@Controller
@RequestMapping()
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value="/personas", method = RequestMethod.GET)
	public String saludar(ModelMap model) throws Exception {
		List<Persona> listaPersonas = personaService.listarTodos();
		model.addAttribute("personas", listaPersonas);
		return "listaPersonas";
	}
	
	
	@RequestMapping(value="/irEditar", method = RequestMethod.GET)
	public ModelAndView irEditar(@RequestParam(value="id") String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("persona");
		mv.addObject("command", personaService.listarPorId(Integer.parseInt(id))); //command es el atributo por defecto que espera un formulario
		return mv;
	}
	
	@RequestMapping(value="/irRegistrar", method = RequestMethod.GET)
	public ModelAndView irRegistrar() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("persona");
		mv.addObject("command", new Persona()); //command es el atributo por defecto que espera un formulario
		return mv;
	}
	
	@RequestMapping(value="/remover", method = RequestMethod.GET)
	public ModelAndView remover(@RequestParam(value="id") String id) throws Exception {
		if(id != null && Integer.parseInt(id) > 0) {
			Persona per = personaService.listarPorId(Integer.parseInt(id));
			if(per != null) {
				personaService.eliminar(per);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listaPersonas");
		mv.addObject("personas", personaService.listarTodos());
		return mv;
	}
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ModelAndView operar(Persona per, ModelMap model) throws Exception {
		if(per.getId() == null) {
			personaService.registrar(per);
		} else {
			personaService.modificar(per);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listaPersonas");
		mv.addObject("personas", personaService.listarTodos());
		return mv;
	}
}
