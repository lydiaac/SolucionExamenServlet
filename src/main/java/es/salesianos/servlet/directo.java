package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.repository.CompanyRepository;


public class directo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CompanyRepository repository = new CompanyRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Crear objeto company con los datos de la req
		Company company = new Company();
		company.setName(req.getParameter("name"));
		company.setCreationDate(Date.valueOf(req.getParameter("creationDate")));
		
		repository.insert(company);
		
		redirect(req, resp);
		
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerCompany.jsp");
		dispatcher.forward(req, resp);
	}
}
