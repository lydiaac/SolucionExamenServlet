package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

@Service
public class VideogameService implements es.salesianos.service.Service<Videogame> {
	
private static Logger log = LogManager.getLogger(CompanyService.class);
	
	@Autowired
	private VideogameRepository repository = new VideogameRepository();

	@Override
	public void insert(Videogame videogame) {
		log.info("Insert new videogame: " + videogame);
		repository.insert(videogame);
	}

	@Override
	public void delete(int id) {
		log.info("Delete new videogame: " + id);
		repository.delete(id);
	}

	@Override
	public List<Videogame> listAll() {
		return repository.listAll();
	}
	
	public List<Videogame> listAllByCompany(int idCompany){
		return repository.listAllByCompany(idCompany);
	}
	
	public List<Videogame> listAllByAge(String age, String order){
		return repository.listAllByAge(age, order);
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}
}
