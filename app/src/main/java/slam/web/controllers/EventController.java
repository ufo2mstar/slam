package slam.web.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import slam.model.Event;

@Controller
public class EventController {

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @RequestMapping(path="event", method=RequestMethod.POST)
    @ResponseBody
    public UUID postEvent(@RequestBody @Valid Event event) {
    	log.debug("recieved an event: " + event);
    	
        return UUID.randomUUID();
    }

}