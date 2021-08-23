package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/company")
    public String company(ModelMap modelMap) {
        List<Company> all = companyRepository.findAll();
        modelMap.addAttribute("company", all);
        return "company";

    }
    @GetMapping("/chooseCompany")
    public String companyName(ModelMap modelMap) {
        List<Company> all = companyRepository.findAll();
        modelMap.addAttribute("company", all);

        return "addEmployee";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/company";
    }

    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam int id) {
        companyRepository.deleteById(id);
        return "redirect:/company";
    }
}