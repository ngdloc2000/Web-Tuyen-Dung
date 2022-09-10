package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.User;
import com.example.web_tuyen_dung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public boolean isExistsUser(String username) {
        return userRepository.existsByUsername(username);
    }
}
