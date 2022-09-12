package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Job;
import com.example.web_tuyen_dung.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public Job save(Job job) {
        return jobRepository.save(job);
    }
}
