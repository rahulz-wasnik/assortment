package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MANY_TO_MANY_PROJECT")
public class ManyToManyProject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANY_TO_MANY_EMPLOYEE_SEQ")
    @SequenceGenerator(name = "MANY_TO_MANY_EMPLOYEE_SEQ" ,sequenceName = "MANY_TO_MANY_EMPLOYEE_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<ManyToManyEmployee> employees;
}
