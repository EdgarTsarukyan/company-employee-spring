package com.example.companyemployeespring.service.impl;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int id) {
        companyRepository.deleteById(id);
    }
}
