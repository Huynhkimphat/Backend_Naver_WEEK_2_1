package com.example.week21.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId", nullable = false)
    private Long employeeId;

    @Column(name="name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="birthDate", nullable = false)
    private Date birthDate;

    @Column(name="gender", nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Department department;


    public Employee(String name, Date birthDate, String gender, Department department){
        this.name=name;
        this.birthDate=birthDate;
        this.gender=gender;
        this.department=department;
    }
}
