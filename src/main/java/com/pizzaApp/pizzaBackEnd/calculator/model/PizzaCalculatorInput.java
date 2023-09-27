package com.pizzaApp.pizzaBackEnd.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PizzaCalculatorInput {
    public double hydration;
    public double saltPercentage;
    public double doughMass;
    public int numberDoughBalls;
    public String method;

}


