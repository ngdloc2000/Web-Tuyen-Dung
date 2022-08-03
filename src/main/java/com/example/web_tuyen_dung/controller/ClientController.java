package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.entity.Client;
import com.example.web_tuyen_dung.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("findByUserId")
    public Client findByUserId(@RequestParam Long userId) {
        return clientService.findClientByUserId(userId);
    }

}
