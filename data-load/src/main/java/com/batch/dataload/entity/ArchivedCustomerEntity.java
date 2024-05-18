package com.batch.dataload.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HISTORICAL_CUSTOMER_INFORMATION")
public class ArchivedCustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORICAL_CUSTOMER_INFORMATION_ID_SEQ")
    @SequenceGenerator(name = "HISTORICAL_CUSTOMER_INFORMATION_ID_SEQ" ,sequenceName = "HISTORICAL_CUSTOMER_INFORMATION_ID_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "MOBILE")
    private String mobile;

}
