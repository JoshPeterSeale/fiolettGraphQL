package com.pizzaApp.pizzaBackEnd.order.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String timestamp;
    String customerName;
    List<String> pizzas;
    List<String> drinks;
    Float price;
    Float cost;
    Boolean alcoholic;
    Boolean vegetarian;
    Boolean vegan;

    public Order(String timestamp, String customerName, List<String> pizzas, List<String> drinks, Float price, Float cost, Boolean alcoholic, Boolean vegetarian, Boolean vegan) {
        this.timestamp = timestamp;
        this.customerName = customerName;
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.price = price;
        this.cost = cost;
        this.alcoholic = alcoholic;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }
}
