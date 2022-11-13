package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String name;
    private String approvalStatus;
    private LocalDateTime recruitmentStartDatetime;
    private LocalDateTime recruitmentEndDatetime;
    private String workPlace;
    private Integer recruitmentAgeMin;
    private Integer recruitmentAgeMax;
    private String jobDescription;
    private String gender;
    private Integer salary;
}
