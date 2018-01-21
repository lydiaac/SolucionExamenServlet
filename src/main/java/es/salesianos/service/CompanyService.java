package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.*;
import es.salesianos.model.*;
import es.salesianos.repository.*;

public class CompanyService implements Service<Company> {
	
	private CompanyAssembler assembler = new CompanyAssembler();
	private CompanyRepository repository = new CompanyRepository();

	@Override
	public Company assembleFromRequest(HttpServletRequest req) {
		Company company = assembler.createFromRequest(req);
		return company;
	}
	
	public void insert(Company company) {
		repository.insert(company);
	}
	
	public void delete(String name) {
		repository.delete(name);
		
	}
	
	@Override
	public List<Company> listAll() {
		return repository.listAll();
	}

}
