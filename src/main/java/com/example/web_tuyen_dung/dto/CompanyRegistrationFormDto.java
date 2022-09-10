package com.example.web_tuyen_dung.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegistrationFormDto {
    private String username;
    private String password;
    private String staffName;
    private String companyName;
    private Integer typeOfBusiness;
    private String url;
    private String tel;
    private Integer prefectureId;
    private String address;
    private String description;
    private Integer employeeQuantity;
    private String avatar;
    private String coverImage;
}
