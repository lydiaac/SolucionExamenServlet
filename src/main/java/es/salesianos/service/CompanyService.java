package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.*;
import es.salesianos.repository.*;

@Service
public class CompanyService implements es.salesianos.service.Service<Company>{
	
	private static Logger log = LogManager.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyRepository repository = new CompanyRepository();
	

	public void insert(Company company) {
		log.info("Insert new comany: " + company);
		repository.insert(company);
	}
	
	public void delete(int id) {
		log.info("Delete new comany: " + id);
		repository.delete(id);
	}
	
	public List<Company> listAll() {
		return repository.listAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
	
	

}
