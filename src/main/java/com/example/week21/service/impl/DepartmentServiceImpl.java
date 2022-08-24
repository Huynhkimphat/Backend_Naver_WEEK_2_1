package com.example.week21.service.impl;

import com.example.week21.model.Department;
import com.example.week21.repository.DepartmentRepository;
import com.example.week21.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    @Override
    public String createNewDepartment(Department department) {
        departmentRepository.save(new Department(department.getDept_name(),department.getDescription()));
        return "Create Success";
    }

    @Override
    public String updateDepartment(Long id, Department department) {
        Optional<Department> departmentRawToUpdate= departmentRepository.findById(id);

        if(!departmentRawToUpdate.isEmpty()){
            Department departmentToUpdate=departmentRawToUpdate.get();
            departmentToUpdate.setDept_name(department.getDept_name());
            departmentToUpdate.setDescription(department.getDescription());
            departmentRepository.save(departmentToUpdate);
            return "Update Success";
        }
        return "Department not exist";
    }

    @Override
    public String deleteDepartment(Long id) {
        Boolean isDepartmentToDeleteExisted=departmentRepository.existsById(id);
        if(isDepartmentToDeleteExisted){
            departmentRepository.deleteById(id);
            return "Delete Success";
        }
        return "Department not exist";
    }

    @Override
    public void initDepartmentData(){
        Department newDepartment=new Department("dept_1","department1");
        Department newDepartment2=new Department("dept_2","department2");
        Department newDepartment3=new Department("dept_3","department3");
        departmentRepository.save(newDepartment);
        departmentRepository.save(newDepartment2);
        departmentRepository.save(newDepartment3);

    }
}
