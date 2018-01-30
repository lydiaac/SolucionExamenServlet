package es.salesianos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

@Repository
public class VideogameRepository implements es.salesianos.repository.Repository<Videogame>{

	private static final String INSERT = "INSERT INTO Videogame (name,recomendedAge,releaseDate,consoleId)" + "VALUES ( :name, :recomendedAge, :releaseDate, :consoleId)";
	private static final String DELETE = "DELETE FROM Videogame WHERE id = ?";
	private static final String SELECT = "SELECT * FROM Videogame";
	private static final String SELECTBYCOMPANY = "SELECT * FROM Videogame a inner join Console b on a.ConsoleID=b.ID WHERE b.CompanyID = :id";
	
	private static final String AGE_TP = "SELECT * FROM Videogame";
	private static final String AGE_07 = "SELECT * FROM Videogame WHERE recomendedAge='07' or recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_13 = "SELECT * FROM Videogame WHERE recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_18 = "SELECT * FROM Videogame WHERE recomendedAge='18'";
		
	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public void insert(Videogame videogame) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", videogame.getName());
		params.addValue("recomendedAge", videogame.getRecomendedAge());
		params.addValue("releaseDate", videogame.getReleaseDate());
		params.addValue("consoleId", videogame.getConsoleId());
		namedJdbcTemplate.update(INSERT, params);
	}

	@Override
	public void delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		namedJdbcTemplate.update(DELETE, params);
	}

	@Override
	public List<Videogame> listAll() {
		List<Videogame> videogames = template.query(SELECT, new BeanPropertyRowMapper(Videogame.class));
		return videogames;
	}
	
	public List<Videogame> listAllByCompany(int idCompany){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", idCompany);
		List<Videogame> videogames = template.query(SELECTBYCOMPANY, new BeanPropertyRowMapper(Console.class));
		return videogames;
	}
	
//	public List<Videogame> listAllByAge(String age, String orderBy){
//		List<Videogame> videogames = new ArrayList<Videogame>();
//		Connection conn = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		String order = selectedOrder(orderBy);
//		try {
//			conn = connection.openConnection(JDBCURL);
//			statement = conn.createStatement();
//			switch(age) {
//			case "TP":
//				resultSet = statement.executeQuery(AGE_TP + order);
//				break;
//			case "07":
//				resultSet = statement.executeQuery(AGE_07 + order);
//				break;
//			case "13":
//				resultSet = statement.executeQuery(AGE_13 + order);
//				break;
//			case "18":
//				resultSet = statement.executeQuery(AGE_18 + order);
//				break;
//			}
//			while (resultSet.next()) {
//				Videogame videogame = new Videogame();
//				videogame.setId(resultSet.getInt("id"));
//				videogame.setName(resultSet.getString("name"));
//				videogame.setRecomendedAge(resultSet.getString("recomendedAge"));
//				videogame.setReleaseDate(resultSet.getDate("releaseDate"));
//				videogame.setConsoleId(resultSet.getInt("consoleId"));
//				videogames.add(videogame);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			connection.closeResultSet(resultSet);
//			connection.closeStatement(statement);
//			connection.closeConnection(conn);
//		}
//		return videogames;
//	}

	private String selectedOrder(String orderBy) {
		String order;
		if(orderBy=="alphabetically") {
			order=" order by name";
		} else {
			order=" order by releaseDate";
			
		}
		return order;
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
}
