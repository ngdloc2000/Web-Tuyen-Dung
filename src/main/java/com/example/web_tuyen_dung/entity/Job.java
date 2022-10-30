package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    private String name;
    private String approvalStatus;
    private Timestamp recruitmentStartDatetime;
    private Timestamp recruitmentEndDatetime;
    private String workPlace;
    private Integer recruitmentAgeMin;
    private Integer recruitmentAgeMax;
    private String jobDescription;
    private String gender;
    private Integer salary;
}