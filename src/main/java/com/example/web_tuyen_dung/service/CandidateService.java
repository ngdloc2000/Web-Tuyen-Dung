package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Candidate;
import com.example.web_tuyen_dung.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate findByUserId(Long userId) {
        return candidateRepository.findByUserId(userId);
    }
}
