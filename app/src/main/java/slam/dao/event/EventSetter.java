package slam.dao.event;

import static slam.dao.support.DaoDataMappingUtil.toSqlTimestamp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import slam.model.Event;

public class EventSetter implements PreparedStatementSetter {

	private Event event;

	public EventSetter(Event event) {
		this.event = event;
	}

	@Override
	public void setValues(PreparedStatement stmt) throws SQLException {
		stmt.setString(1, event.getId().toString());
		stmt.setString(2, event.getCorrelationId().toString());
		stmt.setString(3, event.getEventType());
		stmt.setTimestamp(4, toSqlTimestamp(event.getEstimatedTimeOfArrival()));
		stmt.setString(5, event.getStatus().name());
//		FIXME: why not ternaries? keeps code dry
//		if (event.getParentId() != null) {
//			stmt.setString(6, event.getParentId().toString());
//		} else {
//			stmt.setString(6, null);
//		}
		stmt.setString(6, event.getParentId() != null ? event.getParentId().toString() : null);
		stmt.setTimestamp(7, toSqlTimestamp(event.getCreatedTime()));
		stmt.setTimestamp(8, toSqlTimestamp(event.getModifiedTime()));
	}

}
