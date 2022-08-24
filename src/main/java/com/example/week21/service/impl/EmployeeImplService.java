package com.example.week21.service.impl;

import com.example.week21.model.Employee;
import com.example.week21.model.Employees;
import com.example.week21.repository.EmployeeRepository;
import com.example.week21.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeImplService  implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper mapper;
    @Override
    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> mapper.map(employee, Employees.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Create Success";
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeRawToUpdate= employeeRepository.findById(id);

        if(!employeeRawToUpdate.isEmpty()){
            Employee employeeToUpdate=employeeRawToUpdate.get();
            employeeToUpdate.setName(employee.getName());
            employeeToUpdate.setBirthDate(employee.getBirthDate());
            employeeToUpdate.setGender(employee.getGender());
            employeeRepository.save(employeeToUpdate);
            return "Update Success";
        }
        return "Employee not exist";
    }

    @Override
    public String deleteEmployee(Long id) {
        Boolean isEmployeeToDeleteExisted=employeeRepository.existsById(id);
        if(isEmployeeToDeleteExisted){
            employeeRepository.deleteById(id);
            return "Delete Success";
        }
        return "Department not exist";
    }
}
