package com.iAxis.secure_chat.dto;

import com.iAxis.secure_chat.entity.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 20 Jan, 2025
 */
public class UserMessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private User from;

    private User to;

    private List<MessageDto> messages;

    public UserMessageDto() {
        messages = new ArrayList<>();
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserMessageDto that = (UserMessageDto) o;
        return Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
