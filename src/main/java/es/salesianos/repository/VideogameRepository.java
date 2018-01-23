package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Videogame;

public class VideogameRepository implements Repository<Videogame>{

	private static final String INSERT = "INSERT INTO Videogame (name,recomendedAge,releaseDate,consoleId)" + "VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM Videogame WHERE id = ?";
	private static final String SELECT = "SELECT * FROM Videogame";
	private static final String SELECTBYCOMPANY = "SELECT * FROM Videogame a inner join Console b on a.ConsoleID=b.ID WHERE b.CompanyID = ?";
	
	private static final String AGE_TP = "SELECT * FROM Videogame";
	private static final String AGE_07 = "SELECT * FROM Videogame WHERE recomendedAge='07' or recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_13 = "SELECT * FROM Videogame WHERE recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_18 = "SELECT * FROM Videogame WHERE recomendedAge='18'";
		
	private ConnectionH2 connection = new ConnectionH2();
	
	@Override
	public void insert(Videogame videogame) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERT);
			preparedStatement.setString(1, videogame.getName());
			preparedStatement.setString(2, videogame.getRecomendedAge());
			preparedStatement.setDate(3, videogame.getReleaseDate());
			preparedStatement.setInt(4, videogame.getConsoleId());
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
	public List<Videogame> listAll() {
		List<Videogame> videogames = new ArrayList<Videogame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(SELECT);
			while (resultSet.next()) {
				Videogame videogame = new Videogame();
				videogame.setId(resultSet.getInt("id"));
				videogame.setName(resultSet.getString("name"));
				videogame.setRecomendedAge(resultSet.getString("recomendedAge"));
				videogame.setReleaseDate(resultSet.getDate("releaseDate"));
				videogame.setConsoleId(resultSet.getInt("consoleId"));
				videogames.add(videogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return videogames;
	}
	
	public List<Videogame> listAllByCompany(int idCompany){
		List<Videogame> videogames = new ArrayList<Videogame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement(SELECTBYCOMPANY);
			preparedStatement.setInt(1, idCompany);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogame = new Videogame();
				videogame.setId(resultSet.getInt("id"));
				videogame.setName(resultSet.getString("name"));
				videogame.setRecomendedAge(resultSet.getString("recomendedAge"));
				videogame.setReleaseDate(resultSet.getDate("releaseDate"));
				videogame.setConsoleId(resultSet.getInt("consoleId"));
				videogames.add(videogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeConnection(conn);
			connection.closePreparedStatement(preparedStatement);
		}
		return videogames;
	}
	
	public List<Videogame> listAllByAge(String age, String orderBy){
		List<Videogame> videogames = new ArrayList<Videogame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String order = selectedOrder(orderBy);
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			switch(age) {
			case "TP":
				resultSet = statement.executeQuery(AGE_TP + order);
				break;
			case "07":
				resultSet = statement.executeQuery(AGE_07 + order);
				break;
			case "13":
				resultSet = statement.executeQuery(AGE_13 + order);
				break;
			case "18":
				resultSet = statement.executeQuery(AGE_18 + order);
				break;
			}
			while (resultSet.next()) {
				Videogame videogame = new Videogame();
				videogame.setId(resultSet.getInt("id"));
				videogame.setName(resultSet.getString("name"));
				videogame.setRecomendedAge(resultSet.getString("recomendedAge"));
				videogame.setReleaseDate(resultSet.getDate("releaseDate"));
				videogame.setConsoleId(resultSet.getInt("consoleId"));
				videogames.add(videogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return videogames;
	}

	private String selectedOrder(String orderBy) {
		String order;
		if(orderBy=="alphabetically") {
			order=" order by name";
		} else {
			order=" order by releaseDate";
			
		}
		return order;
	}
	
}
