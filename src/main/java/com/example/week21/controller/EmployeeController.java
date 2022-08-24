package com.example.week21.controller;

import com.example.week21.model.Employee;
import com.example.week21.model.Employees;
import com.example.week21.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value="")
    public String createNewEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(new Employee(employee.getName(),employee.getBirthDate(),employee.getGender(),employee.getDepartment()));
        return "Add Success";
    }

    @GetMapping("")
    public List<Employees> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
