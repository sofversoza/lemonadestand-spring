package com.cooksys.lemonadestand.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name="order_table")  // Annotation for renaming order bc its a reserved keyword in SQL
@Entity                     // @Entity Annotation to tell SpringBoot that this Order class is an Entity (an object that maps to a DB table)
@NoArgsConstructor          // Lombok Annotation instead of generating boiler plates for NoArgsConstructors & Setters & Getters for following JavaBean convention
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;        // wrapper for Long bc we want a nullable value (primitives cannot be null, they have default values)

    @Column(nullable = false)           // not null constraint for total column in the DB table
    private double total;

    // Relationships: the left side of 'to' refers to the class you're in
    // @JoinColumn for all ManyToOne relationships to join their columns & tell DB not to create extra joint tables... AND
        // for all OneToMany side of this relationship, add (mappedBy="the name of the field that corresponds to the OneToMany")
    // if the 'Many' is on the right side of 'To', the field you're annotating needs to be a Collection type
    @OneToMany(mappedBy = "order")
    private List<Lemonade> lemonades;           // one Order to many Lemonade-s, which is why its a List of Lemonade

    @ManyToOne
    @JoinColumn                                 // ManyToOne, needs to join both tables columns
    private Customer customer;                  // each Order belongs to a Customer

    @ManyToOne
    @JoinColumn
    private LemonadeStand lemonadeStand;        // each Order belongs to a LemonadeStand






}
