package com.example.newjavaapi.Controllers;

import com.example.newjavaapi.Models.User;
import com.example.newjavaapi.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("postdata")
    public String saveStuff(@ModelAttribute User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        user.setUsername(username);
        user.setEmail(email);
        userDao.save(user);
        return "redirect:/";
    }

}
