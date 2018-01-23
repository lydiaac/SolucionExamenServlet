package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.VideogameAssembler;
import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

public class VideogameService implements Service<Videogame> {
	
	private VideogameAssembler assembler = new VideogameAssembler();
	private VideogameRepository repository = new VideogameRepository();

	@Override
	public Videogame assembleFromRequest(HttpServletRequest req) {
		Videogame videogame = assembler.createFromRequest(req);
		return videogame;
	}

	@Override
	public void insert(Videogame videogame) {
		repository.insert(videogame);
	}

	@Override
	public void delete(int id) {
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
}
