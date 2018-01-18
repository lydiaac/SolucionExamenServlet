package es.salesianos.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface ConnectionManager {
	
	public String getDriver();
	
	public String getDatabaseUser();

	public String getDatabasePassword();
	
	public Connection openConnection(String jdbcUrl);
	
	public void closeConnection(Connection connection);
	
	public void closeStatement(Statement statement);
	
	public void closePreparedStatement(PreparedStatement prepStatement);
	
	public void closeResultSet(ResultSet resultSet);
	
}
