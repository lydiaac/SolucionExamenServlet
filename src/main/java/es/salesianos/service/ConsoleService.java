package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.*;
import es.salesianos.model.*;
import es.salesianos.repository.*;

public class ConsoleService implements Service<Console> {
	
	private ConsoleAssembler assembler = new ConsoleAssembler();
	private ConsoleRepository repository = new ConsoleRepository();

	@Override
	public Console assembleFromRequest(HttpServletRequest req) {
		Console console = assembler.createFromRequest(req);
		return console;
	}

	@Override
	public void insert(Console console) {
		repository.insert(console);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public List<Console> listAll() {
		return repository.listAll();
	}
	
	public List<Console> listAllByCompany(int idCompany){
		return repository.listAllByCompany(idCompany);
	}
}
