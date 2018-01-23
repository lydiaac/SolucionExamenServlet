package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Console;

public class ConsoleRepository implements Repository<Console> {

	private static final String INSERT = "INSERT INTO Console (name,companyId)" + "VALUES (?, ?)";
	private static final String DELETE = "DELETE FROM Console WHERE id = ?";
	private static final String SELECT = "SELECT * FROM Console";
	private static final String SELECTBYCOMPANY = "SELECT * FROM Console WHERE companyId = ?";
	
	private ConnectionH2 connection = new ConnectionH2();
	
	@Override
	public void insert(Console console) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERT);
			preparedStatement.setString(1, console.getName());
			preparedStatement.setInt(2, console.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement(DELETE);
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
	public List<Console> listAll() {
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(SELECT);
			while (resultSet.next()) {
				Console console = new Console();
				console.setId(resultSet.getInt("id"));
				console.setName(resultSet.getString("name"));
				console.setCompanyId(resultSet.getInt("companyId"));
				consoles.add(console);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return consoles;
	}
	
	public List<Console> listAllByCompany(int idCompany){
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement(SELECTBYCOMPANY);
			preparedStatement.setInt(1, idCompany);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Console console = new Console();
				console.setId(resultSet.getInt("id"));
				console.setName(resultSet.getString("name"));
				console.setCompanyId(resultSet.getInt("companyId"));
				consoles.add(console);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeConnection(conn);
			connection.closePreparedStatement(preparedStatement);
		}
		return consoles;
	}

}
