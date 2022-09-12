package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.common.constants.CityConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/city")
    public Map<Integer, String> getAllCity() {
        return CityConstant.CITITES;
    }
}
