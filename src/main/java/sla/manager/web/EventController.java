package sla.manager.web;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sla.manager.domain.Event;

@RequestMapping("/events")
@Controller
@RooWebScaffold(path = "events", formBackingObject = Event.class, delete = false)
public class EventController {

//	todo: some roo magic for a REST controller
	
}

