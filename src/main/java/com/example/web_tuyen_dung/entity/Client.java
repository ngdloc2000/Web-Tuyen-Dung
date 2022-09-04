package com.example.web_tuyen_dung.entity;

import com.example.web_tuyen_dung.common.constants.UserConstant;
import com.example.web_tuyen_dung.dto.ClientRegistrationFormDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client",
        catalog = "web_tuyen_dung")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
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

    public Client(ClientRegistrationFormDto clientRegistrationFormDto) {
        this.staffName = clientRegistrationFormDto.getStaffName();
        this.companyName = clientRegistrationFormDto.getCompanyName();
        this.typeOfBusiness = clientRegistrationFormDto.getTypeOfBusiness();
        this.url = clientRegistrationFormDto.getUrl();
        this.tel = clientRegistrationFormDto.getTel();
        this.prefectureId = clientRegistrationFormDto.getPrefectureId();
        this.address = clientRegistrationFormDto.getAddress();
        this.description = clientRegistrationFormDto.getDescription();
        this.employeeQuantity = clientRegistrationFormDto.getEmployeeQuantity();
        this.avatar = clientRegistrationFormDto.getAvatar();
        this.coverImage = clientRegistrationFormDto.getCoverImage();
    }
}
