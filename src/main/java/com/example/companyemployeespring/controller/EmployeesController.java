package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeesController {

   private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String employees(ModelMap modelMap) {

        List<Employee> all =employeeService.findAllEmployees();
        modelMap.addAttribute("employees", all);
        return "employees";
    }



    @PostMapping("/addEmployee")

    public String addCompanyPost(@ModelAttribute Employee employee) {

      employeeService.addEmployee(employee);
        return "redirect:/employees";
    }



    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
       employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
