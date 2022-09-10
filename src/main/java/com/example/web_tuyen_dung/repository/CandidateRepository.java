package com.example.web_tuyen_dung.repository;

import com.example.web_tuyen_dung.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByUserId(Long userId);
}
