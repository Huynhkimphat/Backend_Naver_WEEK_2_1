package com.example.week21.repository;

import com.example.week21.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Long> {

}
