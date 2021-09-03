package com.example.companyemployeespring.security;

import com.example.companyemployeespring.entity.Employee;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Employee employee;

    public CurrentUser(Employee employee) {
        super(employee.getEmail(), employee.getPassword(), AuthorityUtils.createAuthorityList(employee.getUserType().name()));
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
