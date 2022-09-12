package com.example.web_tuyen_dung.controller;

import com.example.web_tuyen_dung.entity.Job;
import com.example.web_tuyen_dung.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/save")
    public Job save(@RequestBody Job job) {
        return jobService.save(job);
    }
}
