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
        // Kiểm tra username đã tồn tại
        if (userService.isExistsUser(registrationForm.getUsername())) {
            throw new Exception("Đã tồn tại username");
        }

        // Tạo bản ghi user mới
        User user = modelMapper.map(registrationForm, User.class);
        user.setStatus(UserConstant.Status.ACTIVE);
        user.setType(UserConstant.Type.COMPANY);

        // Tạo bản ghi công ty mới
        Company company = modelMapper.map(registrationForm, Company.class);
        company.setUser(userService.saveUser(user));
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
