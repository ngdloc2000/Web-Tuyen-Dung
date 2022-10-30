package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.common.constants.UserConstant;
import com.example.web_tuyen_dung.dto.CandidateRegistrationFormDto;
import com.example.web_tuyen_dung.dto.LoginForm;
import com.example.web_tuyen_dung.entity.Candidate;
import com.example.web_tuyen_dung.entity.User;
import com.example.web_tuyen_dung.service.CandidateService;
import com.example.web_tuyen_dung.service.UserService;
import com.example.web_tuyen_dung.util.AppException;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("candidate")
public class CandidateController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    CandidateService candidateService;

    @PostMapping("/register")
    public void register(@RequestBody CandidateRegistrationFormDto registrationForm) {
        // Kiểm tra username đã tồn tại
        if (userService.isExistsUser(registrationForm.getUsername())) {
            throw new AppException("Đã tồn tại username");
        }

        // Tạo bản ghi user mới
        User user = modelMapper.map(registrationForm, User.class);
        user.setStatus(UserConstant.Status.ACTIVE);
        user.setType(UserConstant.Type.CANDIDATE);

        // Tạo bản ghi ứng viên mới
        Candidate candidate = modelMapper.map(registrationForm, Candidate.class);
        candidate.setIsOpenProfile(true);
        candidate.setUser(userService.saveUser(user));
        candidateService.saveCandidate(candidate);
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
                result.put("user", null);
                result.put("isLogin", false);
            }
        }

        return result;
    }

    @GetMapping("/{userId}")
    public Candidate findById(@PathVariable("userId") Long userId) {
        return candidateService.findByUserId(userId);
    }


}
