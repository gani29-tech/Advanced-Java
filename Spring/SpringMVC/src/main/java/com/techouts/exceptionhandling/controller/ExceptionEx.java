package com.techouts.exceptionhandling.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionEx {
    @RequestMapping("/exception")
    public String display() {
        return "exception/Login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        if(name.isEmpty()) {
            throw new NullPointerException("Name cannot be empty or null");
        }
        else if(password.isEmpty()) {
            throw new NullPointerException("Password cannot be empty or null");
        }
        else{
            return "exception/Home";
        }
    }
}
