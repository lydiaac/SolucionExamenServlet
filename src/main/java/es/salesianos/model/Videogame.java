package es.salesianos.model;

import java.sql.Date;

public class Videogame {
	
	private int id;
	private String name;
	private String recomendedAge;
	private Date releaseDate;
	private int companyID;
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecomendedAge() {
		return recomendedAge;
	}
	public void setRecomendedAge(String recomendedAge) {
		this.recomendedAge = recomendedAge;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getConsoleID() {
		return companyID;
	}
	public void setConsoleID(int consoleID) {
		this.companyID = consoleID;
	}
	
	

}
