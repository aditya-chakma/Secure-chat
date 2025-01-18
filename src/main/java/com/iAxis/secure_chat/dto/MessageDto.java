package com.iAxis.secure_chat.dto;

import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
public class MessageDto {

    private String message;

    private LocalDateTime time;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
