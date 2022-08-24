package com.example.week21.controller;

import com.example.week21.model.Department;
import com.example.week21.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostConstruct
    public void init(){
        departmentService.initDepartmentData();
    }

    @GetMapping("")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("")
    public String createNewDepartment(@RequestBody Department department){
        return departmentService.createNewDepartment(department);
    }

    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable Long id,@RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
    }

}
