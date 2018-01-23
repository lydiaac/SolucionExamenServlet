package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;

public class ListConsoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ConsoleService service = new ConsoleService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsoles = service.listAll();
		req.setAttribute("listAllConsoles", listAllConsoles);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listConsole.jsp");
		dispatcher.forward(req,resp);
	}
	
	public ConsoleService getService() {
		return service;
	}

	public void setService(ConsoleService service) {
		this.service = service;
	}
}