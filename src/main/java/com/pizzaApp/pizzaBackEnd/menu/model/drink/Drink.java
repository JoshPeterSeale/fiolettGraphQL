package com.pizzaApp.pizzaBackEnd.menu.model.drink;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String name;
    Float cost;
    Float price;
    boolean glutenFree;
    boolean vegetarian;
    boolean vegan;
    boolean alcoholic;

    public Drink(String name, float cost, boolean glutenFree, boolean vegetarian, boolean vegan, boolean alcoholic){
        this.name=name;
        this.cost=cost;
        this.price=(float) (cost * 2.5);
        this.glutenFree=glutenFree;
        this.vegetarian=vegetarian;
        this.vegan=vegan;
        this.alcoholic=alcoholic;
    }
}
