package com.shosha.springboot.demo.jopportal.controller;

import com.shosha.springboot.demo.jopportal.entity.Users;
import com.shosha.springboot.demo.jopportal.entity.UsersType;
import com.shosha.springboot.demo.jopportal.service.UsersServiceImp;
import com.shosha.springboot.demo.jopportal.service.UsersTypeServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private UsersTypeServiceImp usersTypeService;
    private UsersServiceImp usersService;

    @Autowired
    public void setUsersTypeService(UsersTypeServiceImp usersTypeService, UsersServiceImp usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String home(Model model) {
        List<UsersType> usersTypeList = usersTypeService.findAll();
        model.addAttribute("getAllTypes", usersTypeList);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String register(@Valid Users user, Model model) {
        Optional<Users> optionalUser = usersService.getUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            List<UsersType> usersTypeList = usersTypeService.findAll();
            model.addAttribute("error",
                    "The email you entered is already associated with an existing account.");
            model.addAttribute("getAllTypes", usersTypeList);
            model.addAttribute("user", new Users());
            return "register";
        } else {
            usersService.addNew(user);
            return "dashboard";
        }
    }
}
