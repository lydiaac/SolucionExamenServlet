package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface Service<T> {
	
	public T assembleFromRequest(HttpServletRequest req);
	
	public void insert(T t);
	
	public void delete(int id);

	public List<T> listAll();
}
