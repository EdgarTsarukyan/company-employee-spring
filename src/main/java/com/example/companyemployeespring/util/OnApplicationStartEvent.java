package com.example.companyemployeespring.util;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.entity.UserType;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OnApplicationStartEvent implements ApplicationListener {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        if (!employeeRepository.findByEmail("admin").isPresent()) {
            companyRepository.save(Company.builder()
                    .name("admin")
                    .address("admin")
                    .email("admin")
                    .build());

            employeeRepository.save(Employee.builder()
                    .name("admin")
                    .surname("admin")
                    .phoneNumber(111)
                    .salary(1000)
                    .position("admin")
                    .email("admin")
                    .password(passwordEncoder.encode("admin"))
                    .userType(UserType.ADMIN)

                    .build());
        }
    }

}
