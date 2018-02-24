package es.salesianos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Company;

@Repository
public class CompanyRepository implements es.salesianos.repository.Repository<Company>{

	private static final String INSERT = "INSERT INTO Company (name,creationDate)" + "VALUES (:name, :creationDate)";
	private static final String DELETE = "DELETE FROM Company WHERE id = :id";
	private static final String SELECT = "SELECT * FROM Company";
	
	private static final String DELETETABLE = "DELETE FROM :tablename WHERE id = :id";
	
	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;


	public void insert(Company company) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", company.getName());
		params.addValue("creationDate", company.getCreationDate());
		namedJdbcTemplate.update(INSERT, params);
	}


	public void delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		namedJdbcTemplate.update(DELETE, params);
	}
	
	public void delete(String tablename, int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("tablename", tablename);
		params.addValue("id", id);
		namedJdbcTemplate.update(DELETETABLE, params);
	}


	public List<Company> listAll() {
		List<Company> companies = template.query(SELECT, new BeanPropertyRowMapper(Company.class));
		return companies;
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
