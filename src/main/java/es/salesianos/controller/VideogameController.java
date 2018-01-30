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

import es.salesianos.model.Videogame;
import es.salesianos.service.VideogameService;

@Controller
public class VideogameController {
	
private static Logger log = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	@Qualifier(value = "videogameService")
	private VideogameService service;
	
	//INSERT NEW VIDEOGAME POST
	@PostMapping("/registerVideogame")
	public ModelAndView saveVideogame(@ModelAttribute Videogame videogame) {
		service.insert(videogame);
		return new ModelAndView("registerVideogame", "command", new Videogame());
	}
	
	//LIST VIDEOGAMES
	@GetMapping("/listVideogame")
	public ModelAndView listVideogame() {
		ModelAndView modelAndView = new ModelAndView("listVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogames", service.listAll());
		return modelAndView;
	}
}
