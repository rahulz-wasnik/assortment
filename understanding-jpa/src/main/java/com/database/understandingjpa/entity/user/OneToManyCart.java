package com.database.understandingjpa.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ONE_TO_MANY_CART")
public class OneToManyCart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONE_TO_MANY_CART_SEQ")
    @SequenceGenerator(name = "ONE_TO_MANY_CART_SEQ" ,sequenceName = "ONE_TO_MANY_CART_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    
    @OneToMany(mappedBy = "cart")
    // Not adding mapped by will create an additional table containing cart id and items id
    // By adding mapped by you are telling Cart, hey the mapping is already created by items you don't do anything -
    // - there by the cart will not create an additional table
    // https://www.youtube.com/watch?v=VLlDaIcb3jE
    private Set<ManyToOneItems> items;
}
