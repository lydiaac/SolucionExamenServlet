package es.salesianos.repository;

import java.util.List;

public interface Repository<T> {
	
	public static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public static final String USER = "sa";
	
	public static final String PWD = "";
	
	public void insert(T t);
	
	public void delete(int id);
	
	public List<T> listAll();
}
