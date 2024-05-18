package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @Column(name = "user_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
//    @SequenceGenerator(name = "ADDRESS_SEQ" ,sequenceName = "ADDRESS_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    private String city;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
