package com.iAxis.secure_chat.controller;

import com.iAxis.secure_chat.dto.MessageDto;
import com.iAxis.secure_chat.entity.User;
import com.iAxis.secure_chat.repository.UserMessageRepository;
import com.iAxis.secure_chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    private UserService userService;

    @Autowired
    public MessageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{fromId}/{toId}")
    public Map<User, List<MessageDto>> getMessages(@PathVariable Integer fromId, @PathVariable Integer toId) {
        User fromUser = userService.findById(fromId);
        User toUser = userService.findById(toId);

        if (fromUser == null || toUser == null) {
            return Collections.emptyMap();
        }

        return userService.getUserMessage(fromUser, toUser);
    }

}
