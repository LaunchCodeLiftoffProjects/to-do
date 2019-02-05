package org.launchcode.todo.controllers;


import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.data.AddEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

//Defines the class
@Controller
@RequestMapping(value ="addevent")
public class AddEventController {

    //Injecting a instance of AddEventDao here
    @Autowired
    private AddEventDao addEventDao;

    // Request path: /addevent
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("addevents", addEventDao.findAll());
        model.addAttribute("title", "Add Event");

        return "addevent";
    }

    @RequestMapping(value = "addevent", method = RequestMethod.GET)
    public String displayAddEventForm(Model model) {

        model.addAttribute("title", "Add Event");
        model.addAttribute(new AddEvent());

        return "addevent";
    }

    @RequestMapping(value = "addevent", method = RequestMethod.POST)
    public String processAddEventForm(@ModelAttribute @Valid AddEvent newAddEvent,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Event");
            return "dashboard";
        }

        addEventDao.save(newAddEvent);
        return "addevent";
    }
}
