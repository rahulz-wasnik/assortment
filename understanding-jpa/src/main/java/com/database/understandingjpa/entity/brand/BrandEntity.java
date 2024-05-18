package com.database.understandingjpa.entity.brand;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "BRAND")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "brand",
        columnDefinition = "VARCHAR(40)"
)
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_SEQ")
    @SequenceGenerator(name = "BRAND_SEQ" ,sequenceName = "BRAND_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

}
