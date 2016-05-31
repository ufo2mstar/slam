package slam.dao.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
// fixme: how much should I care to remove these unused imports?
// I presume there should be an IDE solution for this cleanup
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.jdbc.core.RowMapper;

import slam.model.Event;
import slam.model.type.StatusType;

public class EventMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int arg1) throws SQLException {

		Event result = new Event();
		result.setId(UUID.fromString(rs.getString("id")));
		// fixme: am having trouble with date formatting.. ie: new Date() toString thing
		result.setCorrelationId(UUID.fromString(rs.getString("correlation_id")));
		result.setEventType(rs.getString("event_type"));
		result.setEstimatedTimeOfArrival(rs.getTimestamp("estimated_time_of_arrival"));
		//	teachme: some help here please.. how do these enum things work? no way to assign them through strings?
		result.setStatus((rs.getString("status").equals("PENDING") ? StatusType.PENDING : StatusType.COMPLETE));
		result.setParentId(null == rs.getString("parent_id") ? null : UUID.fromString(rs.getString("parent_id")));
		result.setCreatedTime(rs.getTimestamp("created_time"));
		result.setModifiedTime(rs.getTimestamp("modified_time"));

//		logger.debug(result);
		return result;
	}

}
