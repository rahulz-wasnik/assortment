package com.database.understandingjpa.entity.brand;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(name = "PERSON_SEQ" ,sequenceName = "PERSON_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    private String gender;
}
