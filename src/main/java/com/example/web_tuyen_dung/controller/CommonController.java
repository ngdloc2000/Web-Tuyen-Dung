package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.common.constants.CityConstant;
import com.example.web_tuyen_dung.common.constants.GenderConstant;
import com.example.web_tuyen_dung.entity.City;
import com.example.web_tuyen_dung.entity.Gender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/city")
    public List<City> getAllCity() {
        return CityConstant.CITITES;
    }

    @GetMapping("/gender")
    public List<Gender> getAllGender() {
        return GenderConstant.GENDERS;
    }
}
