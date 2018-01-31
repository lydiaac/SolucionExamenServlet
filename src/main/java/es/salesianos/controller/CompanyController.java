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

import es.salesianos.service.*;
import es.salesianos.model.*;

@Controller
public class CompanyController {
	
	private static Logger log = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	@Qualifier(value = "companyService")
	private CompanyService service;
	
	
	@GetMapping("/registerCompany")
	public ModelAndView company() {
		return new ModelAndView("registerCompany", "command", new Company());
	}
	
	@PostMapping("/registerCompany")
	public ModelAndView saveCompany(@ModelAttribute Company company) {
		service.insert(company);
		return new ModelAndView("registerCompany", "command", new Console());
	}
	
	//Dropdownlist
	@GetMapping("/registerConsole")
	public ModelAndView console() {
		ModelAndView modelAndView = new ModelAndView("registerConsole", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	//Dropdownlist
	@GetMapping("/listConsolesCompany")
	public ModelAndView listConsolesCompany() {
		ModelAndView modelAndView = new ModelAndView("listConsolesCompany", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	//Dropdownlist
	@GetMapping("/listVideogamesCompany")
	public ModelAndView listVideogamesCompany() {
		ModelAndView modelAndView = new ModelAndView("listVideogamesCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/listCompany")
	public ModelAndView listCompany() {
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/deleteCompany")	
	public ModelAndView deleteCompany(@ModelAttribute("id") String id) {
		ModelAndView model = new ModelAndView("confirmationCompany", "command", new Company());
		model.addObject("id", id);
		return model;
	}

	@PostMapping("/deleteCompany")
	public ModelAndView deleteCompanyConfirm(@ModelAttribute("id") String id) {
		service.delete(Integer.parseInt(id));
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}	
}
