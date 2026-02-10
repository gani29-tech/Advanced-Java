package com.techouts.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.techouts.model.Bike;
import com.techouts.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bikes/")
public class BikeController {
    @Autowired
    private BikeService bikeService;
    @GetMapping("/list")
    public String listBikes(Model model) {
        model.addAttribute("list", bikeService.getAllBikes());
        return "listBikes";
    }
    @PostMapping("/add")
    public String addBike(Bike bike) {
        bikeService.addBike(bike);
        return "redirect:/bikes/list";
    }
}
