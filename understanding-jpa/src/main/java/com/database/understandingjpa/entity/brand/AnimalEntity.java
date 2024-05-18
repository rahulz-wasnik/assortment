package com.database.understandingjpa.entity.brand;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Data
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANIMAL_SEQ")
    @SequenceGenerator(name = "ANIMAL_SEQ" ,sequenceName = "ANIMAL_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    private String category;
}
