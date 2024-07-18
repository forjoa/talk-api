package com.talk_api.talk_api.controller;

import com.talk_api.talk_api.model.User;
import com.talk_api.talk_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
