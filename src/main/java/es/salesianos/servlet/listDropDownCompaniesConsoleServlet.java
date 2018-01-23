package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listDropDownCompaniesConsoleServlet extends CompanyServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listConsolesCompany.jsp");
		dispatcher.forward(req,resp);
	}

}
