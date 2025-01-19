package com.iAxis.secure_chat.repository;

import com.iAxis.secure_chat.entity.User;
import com.iAxis.secure_chat.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    List<UserMessage> getByFromUserAndToUser(User fromUser, User toUser);

}
