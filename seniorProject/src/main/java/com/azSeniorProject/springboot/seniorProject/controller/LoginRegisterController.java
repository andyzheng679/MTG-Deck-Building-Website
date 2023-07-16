package com.azSeniorProject.springboot.seniorProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRegisterController {

    // create mapping for login/main page

    @GetMapping("/main")
    public String testing(Model theModel) {

        theModel.addAttribute("theDate", new java.util.Date());

        return "loginPage";

    }

}
