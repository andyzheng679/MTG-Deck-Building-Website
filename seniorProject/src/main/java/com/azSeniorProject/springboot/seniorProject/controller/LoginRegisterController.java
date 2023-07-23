package com.azSeniorProject.springboot.seniorProject.controller;

import com.azSeniorProject.springboot.seniorProject.dao.UserDAO;
import com.azSeniorProject.springboot.seniorProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegisterController {

    private UserDAO userDAO;

    // Inject the UserDAO bean using constructor injection
    @Autowired
    public LoginRegisterController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // create mapping for login/main page

    @GetMapping("/main")
    public String mainPage() {
        return "loginPage";

    }

    // registration page
    @GetMapping("/registration")
    public String registrationPage(Model theModel) {

        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "registerPage";

    }

    @PostMapping("/submit_registration")
    public String submitRegistration(@ModelAttribute("user") User theUser) {

        // Save the user data to the database using the UserDAO
        userDAO.save(theUser);

        // Redirect to a success page or any other page after successful registration
        return "registrationSuccessPage";
    }


}
