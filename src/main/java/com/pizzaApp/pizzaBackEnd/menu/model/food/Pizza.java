package com.pizzaApp.pizzaBackEnd.menu.model.food;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String name;
    List<String> ingredients;
    float cost;
    float price;
    boolean glutenFree;
    boolean vegetarian;
    boolean vegan;

    public Pizza(String name, List<String> ingredients, float cost, float price, boolean glutenFree, boolean vegeterian, boolean vegan){
        this.name=name;
        this.ingredients=ingredients;
        this.cost=cost;
        this.price=price;
        this.glutenFree=glutenFree;
        this.vegetarian=vegeterian;
        this.vegan=vegan;
    }
}



