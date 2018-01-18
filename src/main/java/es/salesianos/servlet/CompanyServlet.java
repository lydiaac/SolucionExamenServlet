package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.*;
import es.salesianos.model.*;

public class CompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CompanyService service = new CompanyService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company company = service.assembleFromRequest(req);
		service.insert(company);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerCompany.jsp");
		dispatcher.forward(req, resp);
	}
	
	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}

}
