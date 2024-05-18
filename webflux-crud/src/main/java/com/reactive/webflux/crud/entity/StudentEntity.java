package com.reactive.webflux.crud.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @Column("ROLL_NUMBER")
    private Integer rollNumber;

}
