package com.example.week21.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employees {
    private Long employeeId;
    private String name;
    private Date birthDate;
    private String gender;
    private Long departmentId;
}
