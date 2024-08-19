package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MANY_TO_ONE_ITEMS")
public class ManyToOneItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANY_TO_ONE_ITEMS_SEQ")
    @SequenceGenerator(name = "MANY_TO_ONE_ITEMS_SEQ" ,sequenceName = "MANY_TO_ONE_ITEMS_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private OneToManyCart cart;
}
