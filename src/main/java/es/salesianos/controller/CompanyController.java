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
	
	
	//INSERT NEW COMPANY GET
	@GetMapping("/registerCompany")
	public ModelAndView company() {
		return new ModelAndView("registerCompany", "command", new Company());
	}
	
	//INSERT NEW COMPANY POST
	@PostMapping("/registerCompany")
	public ModelAndView saveCompany(@ModelAttribute Company company) {
		service.insert(company);
		return new ModelAndView("registerCompany", "command", new Console());
	}
	
	//INSERT NEW CONSOLE GET - Dropdownlist
	@GetMapping("/registerConsole")
	public ModelAndView console() {
		ModelAndView modelAndView = new ModelAndView("registerConsole", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	//SELECT COMPANY GET - Dropdownlist
	@GetMapping("/listConsolesCompany")
	public ModelAndView listConsolesCompany() {
		ModelAndView modelAndView = new ModelAndView("listConsolesCompany", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	//LIST COMANIES
	@GetMapping("/listCompany")
	public ModelAndView listCompany() {
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	//DELETE COMPANY POST
	@GetMapping("/deleteCompany")
	public ModelAndView deleteCompany(@ModelAttribute String id) {
		ModelAndView model = new ModelAndView("confirmationCompany", "command", new Company());
		model.addObject("id", id);
		return model;
	}
	
	
	//DELETE COMPANY POST
	@PostMapping("/deleteCompany")
	public ModelAndView deleteCompanyConfirm(@ModelAttribute String id) {
		service.delete(Integer.parseInt(id));
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	
}
