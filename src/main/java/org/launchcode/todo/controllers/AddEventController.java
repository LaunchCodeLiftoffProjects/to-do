package org.launchcode.todo.controllers;


//import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.Event;
import org.launchcode.todo.models.Login;
import org.launchcode.todo.models.User;
import org.launchcode.todo.models.data.AddEventDao;
import org.launchcode.todo.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Defines the class
@Controller
//@RequestMapping(value ="addevent")
public class AddEventController {

    //Injecting a instance of AddEventDao here
    @Autowired
    private AddEventDao addEventDao;

    @Autowired
    private UserDao userDao;

    Login login = new Login();
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

        //send all details to dashboard to display events

        return "redirect:/dashboard";

    }


}
