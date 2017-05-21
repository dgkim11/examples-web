package example.spring.web.controller;

import example.spring.web.domain.User;
import example.spring.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
  
    /**
    * Request mapping for user
    */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsersView() {
        ModelAndView mv= new ModelAndView("usersView");
        mv.addObject("users", userService.findAll());
        return mv;
    }
     
    /**
    * Rest web service
    */
    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsersRest() {
        return userService.findAll();
    }
}