package com.example.web_tuyen_dung.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class City {
    private Integer id;
    private String name;

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
