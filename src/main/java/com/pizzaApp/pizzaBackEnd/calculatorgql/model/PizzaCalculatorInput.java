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
public class PizzaCalculatorInput {
    public double hydration;
    public double saltPercentage;
    public double doughMass;
    public int numberDoughBalls;
}
