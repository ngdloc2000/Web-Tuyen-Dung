package com.example.web_tuyen_dung.service;

import com.example.web_tuyen_dung.entity.Company;
import com.example.web_tuyen_dung.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Company> getAllCompanies(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Company> pagedResult = companyRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Company>();
        }
    }
}
