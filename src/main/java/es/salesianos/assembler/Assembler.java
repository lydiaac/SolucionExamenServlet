package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

public interface Assembler<T> {

	T createFromRequest(HttpServletRequest request);
}
