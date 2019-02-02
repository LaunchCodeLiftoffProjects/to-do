package org.launchcode.todo.controllers;


import org.launchcode.todo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "todo")
public class HomeController {

    @RequestMapping(value="/")
    public String index(Model model){

        model.addAttribute("title","My TODO List");

        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginDetails(Model model){

        model.addAttribute("title","Login Form");
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value = "newuser", method = RequestMethod.GET)
    public String newUserDetails(Model model){

        model.addAttribute("title", "SignUp Form");
        model.addAttribute(new User());
        return "newuser";
    }

}
