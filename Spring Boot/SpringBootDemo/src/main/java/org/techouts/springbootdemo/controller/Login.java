package org.techouts.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
    @GetMapping({"/","/login"})
    public String fillForm(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("name") String name,@RequestParam("password") String password){
        if(name.equals(password)){
            return "success";
        }
        else {
            return "failure";
        }
    }
}
