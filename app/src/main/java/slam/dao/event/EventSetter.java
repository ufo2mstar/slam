package slam.dao.event;

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
	}

}
