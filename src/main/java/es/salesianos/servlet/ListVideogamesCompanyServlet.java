package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Videogame;
import es.salesianos.service.VideogameService;

public class ListVideogamesCompanyServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private VideogameService service = new VideogameService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCompany = Integer.parseInt(req.getParameter("companyId"));
		List<Videogame> listAllVideogames = service.listAllByCompany(idCompany);
		req.setAttribute("listAllVideogames", listAllVideogames);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listVideogamesCompany.jsp");
		dispatcher.forward(req,resp);
	}
	
	public VideogameService getService() {
		return service;
	}

	public void setService(VideogameService service) {
		this.service = service;
	}

}
