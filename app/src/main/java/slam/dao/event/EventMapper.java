package slam.dao.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import slam.model.Event;

public class EventMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int arg1) throws SQLException {
		Event result = new Event();
		result.setId(UUID.fromString(rs.getString("id")));
		result.setCorrelationId(
			UUID.fromString(rs.getString("correlationId")));
		
		return result;
	}

}
