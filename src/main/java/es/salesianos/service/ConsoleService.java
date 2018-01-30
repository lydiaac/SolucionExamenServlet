package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.*;
import es.salesianos.repository.*;

@Service
public class ConsoleService implements es.salesianos.service.Service<Console> {
	
	private static Logger log = LogManager.getLogger(CompanyService.class);
	
	@Autowired
	private ConsoleRepository repository = new ConsoleRepository();

	@Override
	public void insert(Console console) {
		log.info("Insert new console: " + console);
		repository.insert(console);
	}

	@Override
	public void delete(int id) {
		log.info("Delete new console: " + id);
		repository.delete(id);
	}

	@Override
	public List<Console> listAll() {
		return repository.listAll();
	}
	
	public List<Console> listAllByCompany(int idCompany){
		return repository.listAllByCompany(idCompany);
	}
	
	public ConsoleRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
}
