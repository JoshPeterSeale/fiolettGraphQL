package com.pizzaApp.pizzaBackEnd.calculatorgql.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PizzaCalculatorOutput {
    public double totalMass;
    public double flour;
    public double water;
    public double salt;
    public double yeast;
}
