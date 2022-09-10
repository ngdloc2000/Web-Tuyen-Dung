package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Company;
import com.example.web_tuyen_dung.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company findByUserId(Long userId) {
        if (Objects.nonNull(userId)) {
            return companyRepository.findByUserId(userId);
        }
        return null;
    }
}
