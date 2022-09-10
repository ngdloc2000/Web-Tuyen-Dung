package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user", catalog = "web_tuyen_dung")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String type;
    private String status;
}
