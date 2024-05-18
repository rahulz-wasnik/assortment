package com.database.understandingjpa.entity.brand;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "I10")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@DiscriminatorValue("Hyundai")
public class I10Entity extends HyundaiEntity {

    // No discriminator column needed

    private String modelNumber;
}
