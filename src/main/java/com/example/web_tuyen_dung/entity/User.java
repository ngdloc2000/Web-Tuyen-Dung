package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user",
        catalog = "web_tuyen_dung")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "type_id", nullable = false)
    private Long typeId;
    @Column(name = "status", nullable = false)
    private Long statusId;
}
