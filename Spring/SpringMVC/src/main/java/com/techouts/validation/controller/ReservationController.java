package com.techouts.validation.controller;

import com.techouts.validation.model.Reservation;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("res") Reservation reservation, BindingResult result, Model model) throws Exception {
        if(result.hasErrors()) {
            return "validation/bookTicket";
        }
        else {
            return "validation/confirmationTicket";
        }
    }
}
