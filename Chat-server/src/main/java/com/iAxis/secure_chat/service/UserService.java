package com.iAxis.secure_chat.service;

import com.iAxis.secure_chat.dto.MessageDto;
import com.iAxis.secure_chat.dto.UserDto;
import com.iAxis.secure_chat.entity.User;
import com.iAxis.secure_chat.entity.UserMessage;
import com.iAxis.secure_chat.repository.UserMessageRepository;
import com.iAxis.secure_chat.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMessageRepository userMessageRepository;

    public UserService(UserRepository userRepository, UserMessageRepository userMessageRepository) {
        this.userRepository = userRepository;
        this.userMessageRepository = userMessageRepository;
    }

    public User findById(Integer id) {
        if (id == null) {
            return null;
        }

        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(UserDto userDto) {
        User user = userDto.getUser();

        if (user.isNew()) {
            encryptPassword(user);
        }

        userRepository.save(user);
    }

    public Map<User, List<MessageDto>> getUserMessage(User fromUser, User toUser) {
        List<UserMessage> fromUserMessages = userMessageRepository.getByFromUserAndToUser(fromUser, toUser);

        List<MessageDto> fromMessageDtos = fromUserMessages.stream()
                .map(UserMessage::toMessageDto)
                .sorted(Comparator.comparing(MessageDto::getTime))
                .collect(Collectors.toList());

        List<UserMessage> toUserMessages = userMessageRepository.getByFromUserAndToUser(toUser, fromUser);

        List<MessageDto> toMessageDtos = toUserMessages.stream()
                .map(UserMessage::toMessageDto)
                .sorted(Comparator.comparing(MessageDto::getTime))
                .collect(Collectors.toList());

        Map<User, List<MessageDto>> userListMap = new HashMap<>();

        userListMap.put(fromUser, fromMessageDtos);
        userListMap.put(toUser, toMessageDtos);

        return userListMap;
    }

    public UserDto getNewUserCmd() {
        return new UserDto();
    }

    public void encryptPassword(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean matchPassword(User user, String rawPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

}
