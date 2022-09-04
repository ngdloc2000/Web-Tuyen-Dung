package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.dto.ClientRegistrationFormDto;
import com.example.web_tuyen_dung.entity.Client;
import com.example.web_tuyen_dung.entity.User;
import com.example.web_tuyen_dung.service.ClientService;
import com.example.web_tuyen_dung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @PostMapping("/saveClient")
    @Transactional
    public Client saveClient(@RequestBody ClientRegistrationFormDto clientRegistrationFormDto) {
        User user = new User(clientRegistrationFormDto);
        Client client = new Client(clientRegistrationFormDto);
        userService.saveUser(user);
        clientService.saveClient(client);
        return client;
    }

    @GetMapping("findByUserId")
    public Client findByUserId(@RequestParam Long userId) {
        return clientService.findClientByUserId(userId);
    }

}
