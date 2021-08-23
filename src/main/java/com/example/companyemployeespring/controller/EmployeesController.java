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
public class EmployeesController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private CompanyRepository companyRepository;

    @GetMapping("/employees")
    public String employees(ModelMap modelMap) {

        List<Employee> all = employeeRepository.findAll();
        modelMap.addAttribute("employees", all);
        return "employees";
    }



    @PostMapping("/addEmployee")

    public String addCompanyPost(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }



    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
