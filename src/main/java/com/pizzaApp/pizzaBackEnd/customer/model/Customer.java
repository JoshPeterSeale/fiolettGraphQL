package com.pizzaApp.pizzaBackEnd.customer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    String lastName;
    @Column(unique = true)
    String emailAddress;
    Integer numberOfOrders;

    public Customer(String firstName, String lastName, String emailAddress, Integer numberOfOrders){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.numberOfOrders = numberOfOrders;
    }
}
