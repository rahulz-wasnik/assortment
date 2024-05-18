package com.scheduler.concurrency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OLD_EMPLOYEE_HISTORY")
@Builder
public class OldEmployeeRecordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PRODUCT_ID")
    @SequenceGenerator(
            name="SEQ_PRODUCT_ID",
            sequenceName="SEQ_PRODUCT_ID"
    )
    private Long id;
    @Column(name = "EMPLOYEE_FIRST_NAME")
    private String employeeFirstName;
    @Column(name = "EMPLOYEE_LAST_NAME")
    private String employeeLastName;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIPCODE")
    private String zipCode;
}
