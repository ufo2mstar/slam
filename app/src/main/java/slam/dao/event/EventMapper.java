package slam.dao.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import slam.model.Event;
import slam.model.type.StatusType;

public class EventMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int arg1) throws SQLException {

		Event result = new Event();
		result.setId(UUID.fromString(rs.getString("id")));
		result.setCorrelationId(UUID.fromString(rs.getString("correlation_id")));
		result.setEventType(rs.getString("event_type"));
		result.setEstimatedTimeOfArrival(rs.getTimestamp("estimated_time_of_arrival"));
		result.setStatus(StatusType.valueOf(rs.getString("status")));
		result.setParentId(null == rs.getString("parent_id") ? null : UUID.fromString(rs.getString("parent_id")));
		result.setCreatedTime(rs.getTimestamp("created_time"));
		result.setModifiedTime(rs.getTimestamp("modified_time"));

		return result;
	}

}
