package slam.dao.event;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import slam.Main;
import slam.model.Event;
import slam.model.type.StatusType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Main.class)
public class EventDaoSqlTest {

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
		testInsert(event); // this implicitly tests the insert method too!

		Event result = dao.find(event.getId());
		CompareStoreAndRetrieveEvents(event, result);
	}

	public void CompareStoreAndRetrieveEvents(Event event, Event result) {
		assertEquals(event.getId(), result.getId());
		assertEquals(event.getCorrelationId(), result.getCorrelationId());
		assertEquals(event.getEventType(), result.getEventType());
		assertEquals(event.getEstimatedTimeOfArrival(), result.getEstimatedTimeOfArrival());
		assertEquals(event.getStatus(), result.getStatus());
		assertEquals(event.getParentId(), result.getParentId());
		assertEquals(event.getCreatedTime(), result.getCreatedTime());
		assertEquals(event.getModifiedTime(), result.getModifiedTime());
	}

	public EventDaoSql getDao() {
		return dao;
	}

	public void setDao(EventDaoSql dao) {
		this.dao = dao;
	}

}
