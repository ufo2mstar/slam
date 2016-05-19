package slam.dao.event;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import slam.model.Event;

@Component
public class EventDaoSql {
	
	private static final String INSERT = "INSERT INTO events (id, correlationId) VALUES (?, ?)";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(final Event event) {
		jdbcTemplate.update(INSERT, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, event.getId().toString());
				stmt.setString(2, event.getCorrelationId().toString());
			}
			
		});
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
