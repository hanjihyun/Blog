package com.springboot.blog.service;


import com.springboot.blog.model.user.User;
import com.springboot.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public Optional<User> findByIdPw(String email) {
        return userRepository.findByEmail(email);
    }
    public String getUserInfo (String id_token) {
        String email="";

        return email;
    }
}
