package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Account;
import com.example.web_tuyen_dung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Account saveUser(Account account) {
        return userRepository.save(account);
    }
}
