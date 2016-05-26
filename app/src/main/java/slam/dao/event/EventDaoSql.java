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

    /**
     * Simple insert into our plugged in DB i presume..
     * Wait, whats the advantage of this over an ORM again?
     * @param event the entire event info.. (will probably be pointing to our future custom event view for this user..)
     */
    public void insert(final Event event) {
        this.getJdbcTemplate().update(INSERT, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement stmt) throws SQLException {
                // question on system exceptions vs custom exception..
                // i have found that custom exceptions have the following advantages
                // 1. log searching becomes so much more easy
                // 2. can distinguish between expected and unexpected errors.. thus helping stats n such
                // maybe dumb, but we can have a whole array of custom exception levels and have global handlers..
                // thoughts? now i am thinkin this is startin to sound more like aops
                stmt.setString(1, event.getId().toString());
                stmt.setString(2, event.getCorrelationId().toString());
            }

        });
    }

    /**
     * Shall we make this a practice before the code complexifies?
     * @param id the specific UUID id you are querying for
     * @return a getNamedParameterJdbcTemplate query return (or something)
     */
    public Event find(UUID id) {
        SqlParameterSource params = new MapSqlParameterSource("id", id.toString());

        return this.getNamedParameterJdbcTemplate()
                .queryForObject(FIND_BY_ID, params, new EventMapper());
    }

}
