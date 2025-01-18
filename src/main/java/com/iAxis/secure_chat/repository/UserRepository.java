package com.iAxis.secure_chat.repository;

import com.iAxis.secure_chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aditya.chakma
 * @since 18 Jan, 2025
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
