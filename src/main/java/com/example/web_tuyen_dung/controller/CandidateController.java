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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("candidate")
public class CandidateController {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://www.instagram.com/yua_mikami/?__a=1&__d=dis";

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    CandidateService candidateService;

    @PostMapping("/register")
    @Transactional
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
        candidate.setUserId(userService.saveUser(user).getId());
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

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates(@RequestParam Integer pageNumber,
                                            @RequestParam Integer pageSize,
                                            @RequestParam(defaultValue = "id") String sortBy) {
        List<Candidate> page = candidateService.getAllUsers(pageNumber, pageSize, sortBy);

        return page;
    }

    @GetMapping("/{userId}")
    public Candidate findById(@PathVariable("userId") Long userId) {
        return candidateService.findByUserId(userId);
    }

    @GetMapping("demo")
    public String demo() throws IOException {
        return sendGET();
    }

    private static String sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        return null;
    }
}
