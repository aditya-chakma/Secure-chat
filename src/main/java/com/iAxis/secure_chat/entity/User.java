package com.iAxis.secure_chat.entity;

import com.iAxis.secure_chat.interfaces.Persistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@Entity
@Table(name = "user")
public class User extends Persistent<Integer> {

    @Id
    private Integer id;

    @NotBlank
    @Size(max = 64)
    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(name = "password", nullable = false, updatable = false)
    private String password;

    @Override
    public Integer getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
