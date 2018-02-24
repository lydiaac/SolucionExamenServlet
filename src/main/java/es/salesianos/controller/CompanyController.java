package es.salesianos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.service.*;
import es.salesianos.model.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/company")
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
	
	//SERVICIO REST
	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Company>> ListAll() {
		return new ResponseEntity<>(service.listAll(), HttpStatus.CREATED);
	}
	
	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Company> create(@RequestBody Company company) {
		service.insert(company);
		return new ResponseEntity<>(company, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity delete(@PathVariable( value = "id", required = true) Integer id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{tablename}/{id}", method = RequestMethod.GET)
	public ResponseEntity delete(@PathVariable(value = "tablename") String tablename, @PathVariable( value = "id") Integer id) {
		service.delete(tablename, id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
}
