package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

public interface Assembler<T> {

	public T createFromRequest(HttpServletRequest request);
}
