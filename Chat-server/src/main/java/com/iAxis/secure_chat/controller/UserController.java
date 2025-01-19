package com.iAxis.secure_chat.controller;

import com.iAxis.secure_chat.dto.UserDto;
import com.iAxis.secure_chat.entity.User;
import com.iAxis.secure_chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String create(ModelMap model) {
        model.addAttribute("userDto", userService.getNewUserCmd());
        return "user";
    }

    @PostMapping
    @ResponseBody
    public User create(@ModelAttribute UserDto userDto) {
        return userDto.getUser();
    }

}
