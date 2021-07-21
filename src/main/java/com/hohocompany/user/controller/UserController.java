package com.hohocompany.user.controller;


import com.hohocompany.user.dto.UserForm;
import com.hohocompany.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("user/sign-in")
    public String userSignInView(){
        return "/user/sing-in";
    }

    @PostMapping("user/sign-in")
    public String userSignIn(UserForm userform){
        System.out.println(userform);
        userService.signIn(userform);
        return "/home/index";
    }

    @GetMapping("user/sign-up")
    public String userSignUpView(){
       return "/user/sing-up";
    }

    @PostMapping("user/sign-up")
    public String userSignUp(UserForm userform){
       userService.signUp(userform.getEmail(), userform.getPassword());
        return "/home/index";
    }

    @GetMapping("user/withdrawal/{id}")
    public String userWithdrawal(@PathVariable Long id){
        userService.withdrawal(id);
        return "/home/index";
    }

}
