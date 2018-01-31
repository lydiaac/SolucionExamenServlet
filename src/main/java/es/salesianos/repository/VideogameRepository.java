package es.salesianos.repository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Videogame;

@Repository
public class VideogameRepository implements es.salesianos.repository.Repository<Videogame>{

	private static final String INSERT = "INSERT INTO Videogame (name,recomendedAge,releaseDate,consoleId)" + "VALUES ( :name, :recomendedAge, :releaseDate, :consoleId)";
	private static final String DELETE = "DELETE FROM Videogame WHERE id = :id";
	private static final String SELECT = "SELECT * FROM Videogame";
	private static final String SELECTBYCOMPANY = "SELECT * FROM Videogame a inner join Console b on a.ConsoleID=b.ID WHERE b.CompanyID = :id";
	
	private static final String AGE_TP = "SELECT * FROM Videogame";
	private static final String AGE_07 = "SELECT * FROM Videogame WHERE recomendedAge='07' or recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_13 = "SELECT * FROM Videogame WHERE recomendedAge='13' or recomendedAge='18'";
	private static final String AGE_18 = "SELECT * FROM Videogame WHERE recomendedAge='18'";
	
	private static Logger log = LogManager.getLogger(VideogameRepository.class);
	
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
		List<Videogame> videogames = new ArrayList<Videogame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList(SELECTBYCOMPANY, new MapSqlParameterSource("id", String.valueOf(idCompany)));		
			for(Map row : rows){
				Videogame videogame = new Videogame();
				videogame.setId(Integer.parseInt(String.valueOf(row.get("id"))));
				videogame.setName((String)(row.get("name")));
				videogame.setRecomendedAge((String)(row.get("recomendedAge")));
				
				
				videogame.setReleaseDate(parseDate(String.valueOf(row.get("releaseDate"))));			
				videogame.setConsoleId(Integer.parseInt(String.valueOf(row.get("consoleId"))));
				videogames.add(videogame);
			}
		return videogames;
	}
	
	public static java.sql.Date parseDate(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");      
        java.util.Date date = null;
        java.sql.Date sqlStartDate =null;         
        try {
        	date  = format.parse(dateString);
        	sqlStartDate = new java.sql.Date(date.getTime());	
        } catch (ParseException ex) {
        	log.error("Error when getting the date", ex);
        }	
        return sqlStartDate;
    }
	
	public List<Videogame> listAllByAge(String age, String orderBy){
		List<Videogame> videogames = new ArrayList<Videogame>();
		String order = selectedOrder(orderBy);
		switch(age) {
		case "TP":
			videogames = template.query(AGE_TP + order, new BeanPropertyRowMapper(Videogame.class));
			break;
		case "07":
			videogames = template.query(AGE_07 + order, new BeanPropertyRowMapper(Videogame.class));
			break;
		case "13":
			videogames = template.query(AGE_13 + order, new BeanPropertyRowMapper(Videogame.class));
			break;
		case "18":
			videogames = template.query(AGE_18 + order, new BeanPropertyRowMapper(Videogame.class));
			break;
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
