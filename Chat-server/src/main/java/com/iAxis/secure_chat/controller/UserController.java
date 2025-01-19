package com.iAxis.secure_chat.controller;

import com.iAxis.secure_chat.entity.User;
import com.iAxis.secure_chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.findAll();
    }

}
