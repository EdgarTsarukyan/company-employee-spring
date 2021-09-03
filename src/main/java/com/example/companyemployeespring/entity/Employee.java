package com.example.companyemployeespring.entity;

import com.sun.xml.bind.v2.schemagen.episode.Package;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String surname;
    private int phoneNumber;
    private int salary;
    private String position;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @ManyToOne

    private Company company;



}
