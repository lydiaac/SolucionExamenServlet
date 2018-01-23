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

public class ListRecommendedAgeServlet extends HttpServlet {
	
private VideogameService service = new VideogameService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String age = (String)(req.getParameter("age"));
		String order = (String)(req.getParameter("order"));
		List<Videogame> listAllVideogames = service.listAllByAge(age, order);
		req.setAttribute("listAllVideogames", listAllVideogames);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listRecommendedAge.jsp");
		dispatcher.forward(req,resp);
	}
	
	public VideogameService getService() {
		return service;
	}

	public void setService(VideogameService service) {
		this.service = service;
	}
}
