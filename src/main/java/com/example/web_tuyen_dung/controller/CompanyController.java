package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.common.constants.UserConstant;
import com.example.web_tuyen_dung.dto.CompanyRegistrationFormDto;
import com.example.web_tuyen_dung.dto.LoginForm;
import com.example.web_tuyen_dung.entity.Company;
import com.example.web_tuyen_dung.entity.User;
import com.example.web_tuyen_dung.service.CompanyService;
import com.example.web_tuyen_dung.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @PostMapping("/register")
    public void register(@RequestBody CompanyRegistrationFormDto registrationForm) throws Exception {
        if (userService.isExistsUser(registrationForm.getUsername())) {
            throw new Exception("Đã tồn tại username");
        }

        User user = modelMapper.map(registrationForm, User.class);
        user.setStatus(UserConstant.StatusUser.ACTIVE);
        user.setType(UserConstant.TypeUser.COMPANY);

        Company company = modelMapper.map(registrationForm, Company.class);
        company.setUserId(userService.saveUser(user).getId());
        companyService.saveCompany(company);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginForm loginForm) {
        Map<String, Object> result = new HashMap<>();

        if (Objects.nonNull(loginForm) && StringUtils.isNoneBlank(loginForm.getUsername()) && StringUtils.isNoneBlank(loginForm.getPassword())) {
            User user = userService.findUserByUsername(loginForm.getUsername(), loginForm.getPassword());
            if (Objects.nonNull(user)) {
                result.put("user", user);
                result.put("isLogin", true);
            } else {
                result.put("isLogin", false);
            }
        }

        return result;
    }

    @GetMapping("/{userId}")
    public Company findById(@PathVariable("userId") Long userId) {
        return companyService.findByUserId(userId);
    }
}
