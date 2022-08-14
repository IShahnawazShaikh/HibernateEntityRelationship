package com.practice.entityrelationship.employee;

import com.practice.entityrelationship.project.ProjectEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    private String empName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProjectEntity> project;

}
