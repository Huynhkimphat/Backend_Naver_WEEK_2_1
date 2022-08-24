package com.example.week21.service;

import com.example.week21.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void initDepartmentData();
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(Long id);
    String createNewDepartment(Department department);
    String updateDepartment(Long id, Department department);
    String deleteDepartment(Long id);

}
