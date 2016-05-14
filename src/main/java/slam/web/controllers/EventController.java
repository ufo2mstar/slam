package slam.web.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import slam.model.Event;

@Controller
public class EventController {

    @RequestMapping(path="event", method=RequestMethod.POST)
    @ResponseBody
    public UUID postEvent(@RequestBody @Valid Event event) {
        return UUID.randomUUID();
    }

}