package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "client",
        catalog = "web_tuyen_dung")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String staffName;
    private String companyName;
    private String url;
    private String tel;
    private Integer prefectureId;
    private String address;
    private String description;
    private String employeeQuantity;
}
