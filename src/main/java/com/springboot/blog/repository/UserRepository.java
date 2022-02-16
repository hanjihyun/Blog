package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.blog.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

}
