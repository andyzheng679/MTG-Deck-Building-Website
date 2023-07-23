package com.azSeniorProject.springboot.seniorProject.controller;

import com.azSeniorProject.springboot.seniorProject.dao.UserDAO;
import com.azSeniorProject.springboot.seniorProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginRegisterController {

    private UserDAO userDAO;

    // Inject the UserDAO bean using constructor injection
    @Autowired
    public LoginRegisterController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // create mapping for login/main page

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";

    }
    @PostMapping("/submit_login")
    public String submitLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Use the UserDAO to retrieve the user with the matching email from the database
        User theUser = userDAO.findByEmail(email);

        // Check if the user exists and if the password matches
        if (theUser != null && theUser.getPassword().equals(password)) {
            // User is authenticated, redirect to the dashboard or any other page
            return "service";
        } else {
            // Invalid credentials, redirect back to the login page with an error message
            return "redirect:/login?error";
        }
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
