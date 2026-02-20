package com.techouts.validation.controller;

import com.techouts.validation.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class FormFill {
     @RequestMapping("/formfill")
    public String formFill(@ModelAttribute("res") Reservation reservation) {
         return "validation/bookTicket";
     }
}
