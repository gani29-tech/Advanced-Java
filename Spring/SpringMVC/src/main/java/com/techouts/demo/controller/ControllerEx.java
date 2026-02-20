package com.techouts.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerEx {
    @RequestMapping("/ex")
    public String display() {
        return "demo/Login";
    }
    @RequestMapping("/log")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        if(name.equals(password)) {
            model.addAttribute("name", name);
            return "demo/Home";
        }
        else{
            model.addAttribute("message","username or password incorrect");
            return "demo/Error";
        }
    }
}
