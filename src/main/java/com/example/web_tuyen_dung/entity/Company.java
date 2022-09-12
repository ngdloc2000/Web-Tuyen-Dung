package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "company", catalog = "web_tuyen_dung")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String staffName;
    private String companyName;
    private String typeOfBusiness;
    private String url;
    private String tel;
    private String city;
    private String address;
    private String description;
    private Integer employeeQuantity;
    private String avatar;
    private String coverImage;
}
