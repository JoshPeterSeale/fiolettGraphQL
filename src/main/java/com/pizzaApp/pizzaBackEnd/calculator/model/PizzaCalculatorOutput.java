package com.pizzaApp.pizzaBackEnd.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PizzaCalculatorOutput {
    public double totalMass;
    public double flour;
    public double water;
    public double salt;
    public double yeast;
    public String method;
}
