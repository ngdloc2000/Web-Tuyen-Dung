package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Client;
import com.example.web_tuyen_dung.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findClientByUserId(Long userId) {
        return clientRepository.findByUserId(userId);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
