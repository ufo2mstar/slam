package slam.dao.event;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import slam.model.Event;

@Component
public class EventDaoSql extends NamedParameterJdbcDaoSupport {

    private static final String INSERT = "INSERT INTO events (id, correlationId) VALUES (?, ?)";

    private static final String FIND_BY_ID = "SELECT * FROM events where id = :id";

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }

    public void insert(final Event event) {
        this.getJdbcTemplate().update(INSERT, new EventSetter(event));
    }

    public Event find(UUID id) {
        SqlParameterSource params = new MapSqlParameterSource("id", id.toString());

        return this.getNamedParameterJdbcTemplate()
                .queryForObject(FIND_BY_ID, params, new EventMapper());
    }

}
