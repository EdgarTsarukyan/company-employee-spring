package com.example.companyemployeespring.service.impl;

import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.repository.EmployeeRepository;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeRepository employeeRepository;
private final PasswordEncoder passwordEncoder;

    @Override
    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }


}
