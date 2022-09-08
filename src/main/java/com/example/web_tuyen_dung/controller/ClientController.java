package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.dto.ClientRegistrationFormDto;
import com.example.web_tuyen_dung.entity.Client;
import com.example.web_tuyen_dung.entity.Account;
import com.example.web_tuyen_dung.service.ClientService;
import com.example.web_tuyen_dung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
        Account account = new Account(clientRegistrationFormDto);
        Client client = new Client(clientRegistrationFormDto);
        userService.saveUser(account);
        clientService.saveClient(client);
        return client;
    }

    @GetMapping("findByUserId")
    public Client findByUserId(@RequestParam Long userId) {
        return clientService.findClientByUserId(userId);
    }

}
