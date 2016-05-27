package slam.dao.event;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import slam.Main;
import slam.model.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Main.class)
public class EventDaoSqlTest {

    @Autowired
    EventDaoSql dao;

    @Test
    public void testInsert() {
        Event event = getEvent();

        dao.insert(event);
    }

    private Event getEvent() {
        Event event = new Event();
        event.setId(UUID.randomUUID());
        event.setCorrelationId(UUID.randomUUID());
        return event;
    }

    @Test
    public void testFindById() {
        Event event = this.getEvent();
        dao.insert(event);

        Event result = dao.find(event.getId());

        assertEquals(event.getId(), result.getId());
        assertEquals(event.getCorrelationId(), result.getCorrelationId());
    }

    public EventDaoSql getDao() {
        return dao;
    }

    public void setDao(EventDaoSql dao) {
        this.dao = dao;
    }

}
