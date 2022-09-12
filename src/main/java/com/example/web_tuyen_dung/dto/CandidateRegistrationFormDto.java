package com.example.web_tuyen_dung.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidateRegistrationFormDto {
    private String username;
    private String password;
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
}
