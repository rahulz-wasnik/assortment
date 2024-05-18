package com.batch.dataload.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ACCOUNT_ID_SEQ")
    @SequenceGenerator(name = "CUSTOMER_ACCOUNT_ID_SEQ" ,sequenceName = "CUSTOMER_ACCOUNT_ID_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    private Integer balance;
}
