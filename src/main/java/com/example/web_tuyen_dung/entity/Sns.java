package com.example.web_tuyen_dung.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sns")
public class Sns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long candidateId;
    private Integer youtubeFollowers;
    private Integer instagramFollowers;
}
