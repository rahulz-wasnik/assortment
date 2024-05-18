package com.database.understandingjpa.entity.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends PersonEntity {

    private String firstName;
    private String lastName;
}
