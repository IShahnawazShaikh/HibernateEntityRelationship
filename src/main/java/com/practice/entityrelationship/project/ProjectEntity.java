package com.practice.entityrelationship.project;

import com.practice.entityrelationship.employee.EmployeeEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;

    private String projectName;

    @ManyToMany(mappedBy = "project",fetch = FetchType.EAGER)
    private List<EmployeeEntity> employee;

}
