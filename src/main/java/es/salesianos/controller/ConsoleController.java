package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController {
	
	private static Logger log = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	@Qualifier(value = "consoleService")
	private ConsoleService service;
	
	//INSERT NEW CONSOLE POST
	@PostMapping("/registerConsole")
	public ModelAndView saveConsole(@ModelAttribute Console console) {
		service.insert(console);
		return new ModelAndView("registerConsole", "command", new Console());
	}
	
	//INSERT NEW VIDEOGAME GET
	@GetMapping("/registerVideogame")
	public ModelAndView videogame() {
		ModelAndView modelAndView = new ModelAndView("registerVideogame", "command", new Videogame());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	//LIST CONSOLES
	@GetMapping("/listConsole")
	public ModelAndView listConsole() {
		ModelAndView modelAndView = new ModelAndView("listConsole", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	//LIST CONSOLES BY COMPANY
	@PostMapping("/listConsolesCompany")
	public ModelAndView listConsolesCompany(@ModelAttribute Company company) {
		ModelAndView modelAndView = new ModelAndView("listConsolesCompany", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAllByCompany(company.getId()));
		return modelAndView;
	}
}
