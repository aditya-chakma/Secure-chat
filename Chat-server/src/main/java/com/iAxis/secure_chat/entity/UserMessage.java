package com.iAxis.secure_chat.entity;

import com.iAxis.secure_chat.dto.MessageDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@Entity
@Table(name = "user_message")
public class UserMessage {

    @Id
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "message_id", updatable = false, nullable = false)
    private Message message;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "from_user_id", updatable = false, nullable = false)
    private User fromUser;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "to_user_id", updatable = false, nullable = false)
    private User toUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public MessageDto toMessageDto() {
        MessageDto messageDto = new MessageDto();

        messageDto.setTime(message.getCreated());
        messageDto.setMessage(message.getMessage());

        return messageDto;
    }

}
