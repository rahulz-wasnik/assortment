package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ" ,sequenceName = "USER_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    
    private String firstName;
    private String lastName;

    /*
    This explains one-to-one relationship with a foreign key
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private AddressEntity address;

    @ManyToMany
    @JoinTable(
            name = "OWNED_CARS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID")
    )
    private List<CarEntity> cars;
}
