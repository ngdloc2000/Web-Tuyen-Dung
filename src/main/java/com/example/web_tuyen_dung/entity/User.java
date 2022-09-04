package com.example.web_tuyen_dung.entity;

import com.example.web_tuyen_dung.common.constants.UserConstant;
import com.example.web_tuyen_dung.dto.ClientRegistrationFormDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user",
        catalog = "web_tuyen_dung")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private int typeId;
    @Column(name = "status", nullable = false)
    private int statusId;

    public User(ClientRegistrationFormDto clientRegistrationFormDto) {
        this.email = clientRegistrationFormDto.getEmail();
        this.password = clientRegistrationFormDto.getPassword();
        this.typeId = UserConstant.TypeUser.CLIENT;
        this.statusId = UserConstant.StatusUser.WAIT;
    }
}
