package slam.dao.event;

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
		Event event = new Event();
		event.setId(UUID.randomUUID());
		event.setCorrelationId(UUID.randomUUID());
		
		dao.insert(event);
	}

	public EventDaoSql getDao() {
		return dao;
	}

	public void setDao(EventDaoSql dao) {
		this.dao = dao;
	}

}
