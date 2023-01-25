package com.cooksys.lemonadestand.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Lemonade {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double lemonJuice;

    @Column(nullable = false)
    private double water;

    @Column(nullable = false)
    private double sugar;

    @Column(nullable = false)
    private int iceCubes;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn
    private Order order;                // 1 Order can have many Lemonades; many Lemonades can go into 1 Order




}
