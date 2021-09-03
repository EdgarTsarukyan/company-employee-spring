package com.example.companyemployeespring.service;

import com.example.companyemployeespring.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompany();

    void addCompany(Company company);

    void deleteCompany(int id);
}
