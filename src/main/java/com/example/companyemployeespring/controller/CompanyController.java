package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import com.example.companyemployeespring.security.CurrentUser;
import com.example.companyemployeespring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

private final CompanyService companyService;

    @GetMapping("/company")
    public String company(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Company> all = companyService.findAllCompany();
        modelMap.addAttribute("company", all);
        log.info("User with {} username opened company page, company.size = {}", currentUser.getEmployee().getEmail(), all.size());

        return "company";

    }
    @GetMapping("/chooseCompany")
    public String companyName(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Company> all = companyService.findAllCompany();
        modelMap.addAttribute("company", all);
        log.info("User with {} username choose company", currentUser.getEmployee().getEmail());

        return "addEmployee";
    }

    @GetMapping("/addCompany")
    public String addCompany(@AuthenticationPrincipal CurrentUser currentUser) {

        log.info("User with {} username open addCompany page", currentUser.getEmployee().getEmail());
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company, @AuthenticationPrincipal CurrentUser currentUser) {
        companyService.addCompany(company);
        log.info("User with {} username added company", currentUser.getEmployee().getEmail());
        return "redirect:/company";
    }

    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {
        companyService.deleteCompany(id);
        log.info("User with {} username delete company", currentUser.getEmployee().getEmail());
        return "redirect:/company";
    }
}