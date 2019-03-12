package org.launchcode.todo.controllers;

//compile("org.thymeleaf.extras:thymeleaf-extras-springsecurity3")

import org.launchcode.todo.models.User;
import org.launchcode.todo.models.data.AddEventDao;
import org.launchcode.todo.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
//@RequestMapping(value = "todo")
public class HomeController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddEventDao addEventDao;

    @RequestMapping(value="dashboard")
    public String index(Model model, HttpSession session){

        String username=(String)session.getAttribute("username");
        //model.addAttribute("AllEvents", addEventDao.findAll());
        User user = userDao.findOne(username);
        model.addAttribute("AllEvents", addEventDao.findByUser(user));
        model.addAttribute("username",username);

        return "dashboard";
    }

    @RequestMapping(value = "completeevent/{id}", method = RequestMethod.GET)
    public String completeEvent(Model model, @PathVariable int id) {

        addEventDao.delete(id);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model){

        model.addAttribute("title","Login Form");
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String processLoginForm(HttpSession  session,@RequestParam("username") String username,
                                   @RequestParam("password") String password, Model model) {

        User user = userDao.findOne(username);
        if(user == null){
            model.addAttribute("message", "you are not Registered");
               return "login";
        }
        else if (user.getUsername().equals(username) && user.getPassword().equals(password)){

            session.setAttribute("username",user.getUsername());
            return "redirect:dashboard";
        }
        else{
            model.addAttribute("message", "Invalid Username and Password");
              return "login";
        }

    }


    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:login";

    }

    @RequestMapping(value = "newuser", method = RequestMethod.GET)
    public String displayNewuserForm(Model model){

        model.addAttribute("title", "SignUp Form");
        model.addAttribute(new User());
        return "newuser";
    }

    @RequestMapping(value="newuser", method=RequestMethod.POST)
    public String processNewuserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model,
                                     @RequestParam String username){

        if(errors.hasErrors()){
            model.addAttribute("title","SignUp Form");
            return "newuser";
        }

        userDao.save(newUser);
        return "redirect:/login";
    }

    @RequestMapping(value = "editaccount", method = RequestMethod.GET)
    public String displayEditUser(Model model, HttpSession session){

        String username = (String)session.getAttribute("username");
        model.addAttribute(userDao.findOne(username));
        return "editaccount";

    }

    @RequestMapping(value = "editaccount", method = RequestMethod.POST)
    public String processEditUser(@ModelAttribute User newUser, Model model, Errors errors){

        userDao.save(newUser);
        return "redirect:dashboard";
    }

}
