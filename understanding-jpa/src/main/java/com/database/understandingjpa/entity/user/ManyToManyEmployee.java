package com.database.understandingjpa.entity.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MANY_TO_MANY_EMPLOYEE")
public class ManyToManyEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANY_TO_MANY_EMPLOYEE_SEQ")
    @SequenceGenerator(name = "MANY_TO_MANY_EMPLOYEE_SEQ" ,sequenceName = "MANY_TO_MANY_EMPLOYEE_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    private String firstName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PROJECTS_WORKED_ON_BY_EMPLOYEES",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<ManyToManyProject> projects;

}
