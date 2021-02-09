package com.example.knio.web;

import com.example.knio.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private final AuthService authService;

    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping
    public String signUpUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String repeatedPassword,
                             @RequestParam String email,
                             @RequestParam String dateOfBirth){

        try {
            this.authService.signUpUser(username, password, repeatedPassword, email, dateOfBirth);
            return "redirect:/login?message=SuccesfullRegistration!";
        }catch (RuntimeException ex){
            return "redirect:/signup?error=" + ex.getLocalizedMessage();
        }
    }

}
