package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

public interface Service<T> {
	
	T assembleFromRequest(HttpServletRequest req);
}
