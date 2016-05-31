package slam.dao.event;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import slam.Main;
import slam.model.Event;
import slam.model.type.StatusType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Main.class)
public class EventDaoSqlTest {

	private static final Logger log = LoggerFactory.getLogger(EventDaoSqlTest.class);
	
	@Autowired
	EventDaoSql dao;

	public void testInsert() {
		Event event = getEvent();
		dao.insert(event);
	}

	public void testInsert(Event event) {
		dao.insert(event);
	}

	private Event getEvent() {
		Event event = new Event();
		event.setId(UUID.randomUUID());
		event.setCorrelationId(UUID.randomUUID());
		event.setEventType("EventRecieved");
		event.setEstimatedTimeOfArrival(new Date());
		event.setStatus(StatusType.PENDING);
		event.setParentId(null);
		event.setCreatedTime(new Date());
		event.setModifiedTime(new Date());
		return event;
	}

	@Test
	public void testFindById() {
		Event event = this.getEvent();
		testInsert(event);

		Event result = dao.find(event.getId());
		log.debug("event: " + event);
		log.debug("result: " + result);
		
		assertTrue(new ReflectionEquals(event, (String[]) null).matches(result));
	}

	public EventDaoSql getDao() {
		return dao;
	}

	public void setDao(EventDaoSql dao) {
		this.dao = dao;
	}

}
