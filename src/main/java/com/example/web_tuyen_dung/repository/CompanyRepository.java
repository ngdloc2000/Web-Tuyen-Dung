package com.example.web_tuyen_dung.repository;

import com.example.web_tuyen_dung.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByUserId(Long userId);
}
