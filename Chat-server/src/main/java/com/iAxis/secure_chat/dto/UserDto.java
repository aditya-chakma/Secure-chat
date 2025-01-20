package com.iAxis.secure_chat.dto;

import com.iAxis.secure_chat.entity.User;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 19 Jan, 2025
 */
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

}
