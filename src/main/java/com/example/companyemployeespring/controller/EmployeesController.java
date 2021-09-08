package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.security.CurrentUser;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EmployeesController {

   private final EmployeeService employeeService;


    @GetMapping("/employees")
    public String employees(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {

        List<Employee> all =employeeService.findAllEmployees();
        modelMap.addAttribute("employees", all);
        log.info("User with {} username opened employees page, employee.size = {}", currentUser.getEmployee().getEmail(), all.size());
        return "employees";
    }



    @PostMapping("/addEmployee")

    public String addCompanyPost(@ModelAttribute Employee employee, @AuthenticationPrincipal CurrentUser currentUser) {

      employeeService.addEmployee(employee);
      log.info("user with {} username added employee", currentUser.getEmployee().getEmail());
        return "redirect:/employees";
    }



    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {
       employeeService.deleteEmployeeById(id);
        log.info("User with {} username delete employee", currentUser.getEmployee().getEmail());

        return "redirect:/employees";
    }
}
