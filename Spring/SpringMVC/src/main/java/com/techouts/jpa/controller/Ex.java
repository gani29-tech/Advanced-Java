package com.techouts.jpa.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Ex {
    @GetMapping("/hi")
    public String hi(HttpServletRequest request) {
        System.out.println(request.getAttribute("_csrf"));
        return "hi";
    }
}
