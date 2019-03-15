package org.launchcode.todo.controllers;


//import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.Event;
import org.launchcode.todo.models.User;
import org.launchcode.todo.models.data.AddEventDao;
import org.launchcode.todo.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


//Defines the class
@Controller
//@RequestMapping(value ="addevent")
public class AddEventController {

    //Injecting a instance of AddEventDao here
    @Autowired
    private AddEventDao addEventDao;

    @Autowired
    private UserDao userDao;


    User user = new User();



    @RequestMapping(value = "addevent", method = RequestMethod.GET)
    public String displayAddEventForm(Model model) {

        model.addAttribute("title", "Add Event");
        model.addAttribute(new Event());
        System.out.println("display event form");
        return "addevent";
    }

    @RequestMapping(value = "addevent", method = RequestMethod.POST)
    public String processAddEventForm(@ModelAttribute @Valid Event newAddEvent,
                                      HttpSession session, Errors errors, Model model,
                                      HttpServletRequest request, HttpServletResponse response) {


       System.out.println("new event" + newAddEvent);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Event");
            return "addevent";

        }

        String name =(String)session.getAttribute("username");
        System.out.println(name+" is session name");
        User user = userDao.findOne(name);
        newAddEvent.setUser(user);

        HttpSession session1 = request.getSession();
        session1.setAttribute("username",name);

        addEventDao.save(newAddEvent);

        return "redirect:/dashboard";

    }

    @RequestMapping(value = "edittask/{id}", method = RequestMethod.GET)
    public String editEvent(@PathVariable int id, Model model) {

        Event event = addEventDao.findOne(id);
        model.addAttribute("event", event);
        System.out.println(event);
        return "edittask";
    }

    @RequestMapping(value = "edittask/{id}", method = RequestMethod.POST)
    public String processEditEvent(@ModelAttribute @Valid Event event, Errors errors, Model model,HttpSession session) {


//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Edit Task");
//            return "edittask";

    //    }

        String name =(String)session.getAttribute("username");
        User user = new User();
        user.setUsername(name);
        event.setUser(user);


        addEventDao.save(event);
        return "redirect:/dashboard";
//        event = addEventDao.findOne(event.getId());
//        System.out.println(event);
//
//        event.setStart_Time(newAddEvent.getStart_Time());
//        event.setFinish_Time(newAddEvent.getFinish_Time());
//        event.setLocation(newAddEvent.getLocation());
//        event.setType(newAddEvent.getType());
//        event.setDescription(newAddEvent.getDescription());
//        event.setEventDate(newAddEvent.getEventDate());



        }


    }



