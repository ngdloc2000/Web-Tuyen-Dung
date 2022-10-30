package com.example.web_tuyen_dung.common.constants;

import com.example.web_tuyen_dung.entity.Gender;

import java.util.Arrays;
import java.util.List;

public class GenderConstant {
    public static List<Gender> GENDERS = Arrays.asList(
            new Gender(1, "Nam"),
            new Gender(2, "Nữ")
    );
}
