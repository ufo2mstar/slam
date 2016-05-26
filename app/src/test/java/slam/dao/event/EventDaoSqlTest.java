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
// oh.. is this how junits look?
//	is there no wrapping structure like rspec?

//	btw.. also want to discuss this right away so that we are on the same page
//	I vote for spaces over tabs.. History of discourse on the internet
//	http://programmers.stackexchange.com/questions/57/tabs-versus-spaces-what-is-the-proper-indentation-character-for-everything-in-e
//	http://joshondesign.com/2014/09/02/bar
//  and for a more exhaustive list of search results,
//  https://www.google.com/search?rlz=1C1CHZL_enUS679US679&espv=2&q=tabs+vs+spaces+java&oq=tabs+vs+spaces+java&gs_l=serp.3..0i20j0i22i30l2.1393.2067.0.2245.5.5.0.0.0.0.126.524.2j3.5.0....0...1.1.64.serp..0.5.523...0.bsT6Tv_4CSg

//	but if even Google Styleguide does not convince you....... then i have nothing to say.. please consider..
//	https://google.github.io/styleguide/javaguide.html#s2.3.1-whitespace-characters

//	also i feel like i should be doing a better job communicating these than as code comments! do suggest a means of comment communication..
//	I have not used Crucible/Stash-ish code review systems.. maybe therein lies my ans..

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
