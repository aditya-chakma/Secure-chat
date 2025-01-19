package com.iAxis.secure_chat.entity;

import com.iAxis.secure_chat.interfaces.Persistent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

import static com.iAxis.secure_chat.utils.StringUtils.isEmpty;
import static com.iAxis.secure_chat.utils.StringUtils.isNotEmpty;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
@Entity
@Table(name = "user")
public class User extends Persistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
