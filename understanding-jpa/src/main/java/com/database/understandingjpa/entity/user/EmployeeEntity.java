package com.database.understandingjpa.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.List;

/*
This class is showcase one to many mapping on the same class
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    @SequenceGenerator(name = "EMPLOYEE_SEQ" ,sequenceName = "EMPLOYEE_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    private String firstName;
    private String lastName;

    @Formula("CONCAT(firstName, ' ', lastName)")
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees;

}
