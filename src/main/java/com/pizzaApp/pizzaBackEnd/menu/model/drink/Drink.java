package com.pizzaApp.pizzaBackEnd.menu.model.drink;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GeneratedValue
    Integer id;
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
        this.glutenFree=glutenFree;
        this.vegetarian=vegetarian;
        this.vegan=vegan;
        this.alcoholic=alcoholic;
    }
}
