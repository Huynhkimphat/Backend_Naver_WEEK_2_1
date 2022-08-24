package com.example.week21.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="departmentId",nullable = false)
    private Long departmentId;

    @Column(name="dept_name",nullable = false)
    private String dept_name;

    @Column(name="description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    private Set<Employee> employees;

    public Department(String dept_name, String description){
        this.dept_name=dept_name;
        this.description=description;
    }
}
