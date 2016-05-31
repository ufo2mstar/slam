package slam.dao.event;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import slam.dao.IncorrectDataModificationSizeException;
import slam.model.Event;

@Component
public class EventDaoSql extends NamedParameterJdbcDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(EventDaoSql.class);
	
	private static final String INSERT = "INSERT INTO events " +
			"(id, correlation_id, event_type, estimated_time_of_arrival, status, parent_id, created_time, modified_time) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String FIND_BY_ID = "SELECT * FROM events where id = :id";

	@Autowired
	public void setTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}

	public void insert(final Event event) {
		int insertCount = this.getJdbcTemplate().update(INSERT, new EventSetter(event));
		log.debug("Running insert, event: " + event);
		if (1 != insertCount) {
			throw new IncorrectDataModificationSizeException(1, insertCount);
		}
	}

	public Event find(UUID id) {
		SqlParameterSource params = new MapSqlParameterSource("id", id.toString());
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_ID, params, new EventMapper());
	}

}
