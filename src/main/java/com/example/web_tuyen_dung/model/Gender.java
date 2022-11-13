package com.example.web_tuyen_dung.model;

import lombok.Getter;

@Getter
public class Gender {
    private Integer id;
    private String name;

    public Gender(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
