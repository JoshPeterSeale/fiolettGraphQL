package com.pizzaApp.pizzaBackEnd.menu.model.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="pizza")
public class Pizza {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    List<String> ingredients;

    public Pizza(String name, List<String> ingredients){
        this.name=name;
        this.ingredients=ingredients;
    }
}


