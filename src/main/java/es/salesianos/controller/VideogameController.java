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
	

	@PostMapping("/registerVideogame")
	public ModelAndView saveVideogame(@ModelAttribute Videogame videogame) {
		service.insert(videogame);
		return new ModelAndView("registerVideogame", "command", new Videogame());
	}
	
	@GetMapping("/listVideogame")
	public ModelAndView listVideogame() {
		ModelAndView modelAndView = new ModelAndView("listVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogames", service.listAll());
		return modelAndView;
	}
	
	@PostMapping("/listVideogamesCompany")
	public ModelAndView listVideogamesCompany(@ModelAttribute("id") String companyId) {
		ModelAndView modelAndView = new ModelAndView("listVideogamesCompany", "command", new Videogame());
		modelAndView.addObject("listAllVideogames", service.listAllByCompany(Integer.parseInt(companyId)));
		return modelAndView;
	}
	
	@GetMapping("/deleteVideogame")	
	public ModelAndView deleteVideogame(@ModelAttribute("id") String id) {
		ModelAndView model = new ModelAndView("confirmationVideogame", "command", new Videogame());
		model.addObject("id", id);
		return model;
	}

	@PostMapping("/deleteVideogame")
	public ModelAndView deleteVideogameConfirm(@ModelAttribute("id") String id) {
		service.delete(Integer.parseInt(id));
		ModelAndView modelAndView = new ModelAndView("listVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogames", service.listAll());
		return modelAndView;
	}
	
	///////
	@GetMapping("/listRecommendedAge")
	public ModelAndView listRecommendedAgeAndOrder() {
		ModelAndView modelAndView = new ModelAndView("listRecommendedAge");
	    modelAndView.addObject("age");
	    modelAndView.addObject("order");
	    return modelAndView;
	}
	
	@PostMapping("/listRecommendedAge")
	public ModelAndView listRecommendedAge(@ModelAttribute("age") String age, @ModelAttribute("order") String order) {
		ModelAndView modelAndView = new ModelAndView("listRecommendedAge", "command", new Videogame());
		modelAndView.addObject("listAllVideogames", service.listAllByAge(age, order));
		return modelAndView;
	}
}
