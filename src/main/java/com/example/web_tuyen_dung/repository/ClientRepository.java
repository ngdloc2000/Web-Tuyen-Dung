package com.example.web_tuyen_dung.repository;

import com.example.web_tuyen_dung.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUserId(Long userId);
}
