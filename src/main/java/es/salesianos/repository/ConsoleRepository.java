package es.salesianos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Console;

@Repository
public class ConsoleRepository implements es.salesianos.repository.Repository<Console> {

	private static final String INSERT = "INSERT INTO Console (name,companyId)" + "VALUES ( :name, :companyId)";
	private static final String DELETE = "DELETE FROM Console WHERE id = :id";
	private static final String SELECT = "SELECT * FROM Console";
	private static final String SELECTBYCOMPANY = "SELECT * FROM Console WHERE companyId = :id";
	
	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public void insert(Console console) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		params.addValue("companyId", console.getCompanyId());
		namedJdbcTemplate.update(INSERT, params);
	}

	@Override
	public void delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		namedJdbcTemplate.update(DELETE, params);
	}

	@Override
	public List<Console> listAll() {
		List<Console> consoles = template.query(SELECT, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}
	
	public List<Console> listAllByCompany(int idCompany){
		List<Console> consoles = new ArrayList<Console>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList(SELECTBYCOMPANY, new MapSqlParameterSource("id", String.valueOf(idCompany)));		
			for(Map row : rows){
				Console console = new Console();
				console.setId(Integer.parseInt(String.valueOf(row.get("id"))));
				console.setName((String)(row.get("name")));
				console.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
				consoles.add(console);
			}
		return consoles;	
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
