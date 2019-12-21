package app.controller;

import app.model.Login;
import app.model.User;
import app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute(value = "login") Login login) {
        ModelAndView modelAndView;
        User user = userService.checkUser(login);
        if(user != null) {
            modelAndView = new ModelAndView("/user/loginSuccess");
            modelAndView.addObject("user",user);
        } else {
             modelAndView = new ModelAndView("/user/login");
            modelAndView.addObject("check",false);
        }
        return modelAndView;
    }
}
