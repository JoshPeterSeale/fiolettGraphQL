package com.pizzaApp.pizzaBackEnd.menu.model.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    Float cost;
    boolean glutenFree;
    boolean vegetarian;
    boolean vegan;

    public Ingredient(String name, float cost, boolean glutenFree, boolean vegetarian, boolean vegan){
        this.name=name;
        this.cost=cost;
        this.glutenFree=glutenFree;
        this.vegetarian=vegetarian;
        this.vegan=vegan;
    }
}
