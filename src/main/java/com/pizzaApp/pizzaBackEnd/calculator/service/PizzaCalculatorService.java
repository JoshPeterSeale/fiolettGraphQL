package com.pizzaApp.pizzaBackEnd.calculator.service;

import com.pizzaApp.pizzaBackEnd.calculator.model.PizzaCalculatorInput;
import com.pizzaApp.pizzaBackEnd.calculator.model.PizzaCalculatorOutput;
import org.springframework.stereotype.Service;

import static java.lang.Math.round;

@Service
public class PizzaCalculatorService {

    public PizzaCalculatorOutput pizzaCalculator(PizzaCalculatorInput input) {
        double totalMass = round(input.getNumberDoughBalls() * input.getDoughMass());
        double yeast;
        if (totalMass <= 500) {
            yeast = 3;
        } else if (totalMass <= 1000) {
            yeast = 5;
        } else {
            yeast = round(5 + (totalMass - 1000) * 0.001);
        }

        double flour = round((totalMass - yeast) / (1 + input.getHydration() + input.getSaltPercentage()));
        double water = round( flour * input.getHydration());
        double salt = round(flour * input.getSaltPercentage());
        String method = input.getMethod();

        return new PizzaCalculatorOutput(totalMass, flour, water, salt, yeast, method);
    }
}
