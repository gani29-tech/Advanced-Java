package com.techouts.controller;

import com.techouts.entity.User;
import com.techouts.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
    @GetMapping("/home")
    public String home(HttpSession session, @AuthenticationPrincipal User user) {
        session.setAttribute("currentUser",user);
        return "home";
    }
    @GetMapping("/user/update")
    public String updateUser() {
        return "update_user";
    }
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        userService.updateUser(user,(User)model.getAttribute("currentUser"));
        return "/home";
    }
}
