package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "candidate", catalog = "web_tuyen_dung")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String fullName;
    private String avatar;
    private LocalDate birthdate;
    private String city;
    private Integer height;
    private Integer weight;
    private String specialSkill;
    private Integer yearExp;
    private String tel;
    private String gender;
    private String image2;
    private String image3;
    private String image4;
    private String youtubeName;
    private String twitterName;
    private String instagramName;
    private Boolean isOpenProfile;
}
