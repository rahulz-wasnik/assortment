package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQ")
    @SequenceGenerator(name = "CAR_SEQ" ,sequenceName = "CAR_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    private String modelName;

    @ManyToMany(mappedBy = "cars")
    private List<UserEntity> users;
}
