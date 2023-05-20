package com.company.shopping.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public String login()
    {
        return null;
    }
    @PostMapping("/signup")
    public String signUp()
    {
        return null;
    }

}
