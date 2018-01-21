package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public interface Service<T> {
	
	T assembleFromRequest(HttpServletRequest req);

	List<T> listAll();
}
