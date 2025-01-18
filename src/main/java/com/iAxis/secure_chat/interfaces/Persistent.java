package com.iAxis.secure_chat.interfaces;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@MappedSuperclass
public abstract class Persistent<T> {

    public abstract T getId();

    LocalDateTime created;

    LocalDateTime updated;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
