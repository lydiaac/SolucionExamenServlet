package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Company;

public class CompanyRepository implements Repository<Company> {

	ConnectionH2 connection; 
	
	private static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	
	@Override
	public void insert(Company company) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			System.out.print("entro");
			preparedStatement = conn.prepareStatement("INSERT INTO Company (name,creationDate)" + "VALUES (?, ?)");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setDate(2, company.getCreationDate());
			preparedStatement.executeUpdate();
			System.out.print("insert exito");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closePreparedStatement(preparedStatement);
		}

		connection.closeConnection(conn);
	}

	@Override
	public void update(Company company, Integer id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement("UPDATE company SET " + "name = ?, creationDate = ? WHERE id = ?");

			preparedStatement.setString(1, company.getName());
			preparedStatement.setDate(2, company.getCreationDate());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
		
	}

	@Override
	public void delete(Integer id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE FROM Company WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
		
	}

	@Override
	public List<Company> listAll() {
		List<Company> companies = new ArrayList<Company>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Company");

			while (resultSet.next()) {				
				Company comp = new Company();
				comp.setName(resultSet.getString("name"));
				comp.setCreationDate(resultSet.getDate("creationDate"));
				companies.add(comp);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return companies;
	}

}
