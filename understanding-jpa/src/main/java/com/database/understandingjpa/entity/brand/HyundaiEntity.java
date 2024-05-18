package com.database.understandingjpa.entity.brand;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HYUNDAI")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class HyundaiEntity extends BrandEntity {

    // No discriminator column needed

    @Column(name = "modelName")
    private String modelName;

}
