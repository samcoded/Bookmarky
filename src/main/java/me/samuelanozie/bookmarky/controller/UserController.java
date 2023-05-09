package me.samuelanozie.bookmarky.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    @GetMapping("login")
    public String loginUser() {
        return "Login";
    }

    @PostMapping("register")
    public String registerUser() {
        return "Register";
    }

    @GetMapping("users")
    public String getAllUsers() {
        return "All users";
    }

    @GetMapping("users/{id}")
    public String getUser(@PathVariable Long id) {
        return "User with id of " + id;
    }


}
