package com.example.companyemployeespring.service;

import com.example.companyemployeespring.entity.Employee;

import java.util.List;

public interface EmployeeService {



    void addEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();
}
