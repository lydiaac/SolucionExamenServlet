package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;

public abstract class CompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CompanyService service = new CompanyService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompanies = service.listAll();
		req.setAttribute("listAllCompanies", listAllCompanies);
		redirect(req,resp);
	}
	
	protected abstract void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}

}
