package com.pizzaApp.pizzaBackEnd.calculatorgql.service;

import com.pizzaApp.pizzaBackEnd.calculatorgql.model.PizzaCalculatorInput;
import com.pizzaApp.pizzaBackEnd.calculatorgql.model.PizzaCalculatorOutput;
import org.springframework.stereotype.Component;

import static java.lang.Math.round;

@Component
public class PizzaCalculatorService {

    public PizzaCalculatorOutput pizzaCalculatorOutput(PizzaCalculatorInput input) {

        double totalMass = round(input.getNumberDoughBalls() * input.getDoughMass());

        double yeast;
        if (totalMass <= 500) {
            yeast = 3;
        } else if (totalMass <= 1000) {
            yeast = 5;
        } else {
            yeast = round(5 + (totalMass - 1000) * 0.001);
        } // use a better function for this that takes temperature into account

        double flour = round((totalMass - yeast) / (1 + input.getHydration() + input.getSaltPercentage()));
        double water = round( flour * input.getHydration());
        double salt = round(flour * input.getSaltPercentage());

        return new PizzaCalculatorOutput(totalMass, flour, water, salt, yeast);
    }
}
