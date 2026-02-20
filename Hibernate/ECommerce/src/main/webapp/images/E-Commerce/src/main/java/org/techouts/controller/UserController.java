package org.techouts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.techouts.model.User;
import org.techouts.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        if(userService.save(user)!=null) {
            return "redirect:/user";
        }
        else{
            return "redirect:/signup";
        }
    }
}
