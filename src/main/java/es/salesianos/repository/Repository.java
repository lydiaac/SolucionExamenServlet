package es.salesianos.repository;

import java.util.List;

public interface Repository<T> {
	
	//static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	static final String USER = "sa";
	
	static final String PWD = "";
	
	void insert(T t);
	
	void update(T t, Integer id);
	
	void delete(String name);
	
	List<T> listAll();
}
