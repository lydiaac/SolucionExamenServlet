package es.salesianos.assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.*;

public class CompanyAssembler implements Assembler<Company> {
	
	public Company createFromRequest(HttpServletRequest request) {
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setCreationDate(Date.valueOf(request.getParameter("creationDate")));
		return company;
	}
}
