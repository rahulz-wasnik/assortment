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
@Table(name = "DOG")
public class DogEntity extends AnimalEntity {

    // No discriminator column needed

    private String species;
}
