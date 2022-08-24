package com.example.week21.service;

import com.example.week21.model.Employee;
import com.example.week21.model.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employees> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    String createEmployee(Employee employee) ;
    String updateEmployee(Long id, Employee employee);
    String deleteEmployee(Long id);

}
