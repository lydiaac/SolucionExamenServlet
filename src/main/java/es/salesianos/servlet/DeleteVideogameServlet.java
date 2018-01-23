package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.VideogameService;

public class DeleteVideogameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private VideogameService service = new VideogameService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		service.delete(id);	
		redirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		confirmationRedirect(req, resp);
	}

	protected void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmationVideogame.jsp");
		dispatcher.forward(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listVideogame.jsp");
		dispatcher.forward(req, resp);
	}
	
	public VideogameService getService() {
		return service;
	}

	public void setService(VideogameService service) {
		this.service = service;
	}

}
