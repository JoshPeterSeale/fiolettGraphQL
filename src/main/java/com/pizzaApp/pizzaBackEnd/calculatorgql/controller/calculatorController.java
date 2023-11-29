package com.pizzaApp.pizzaBackEnd.calculatorgql.controller;

import com.pizzaApp.pizzaBackEnd.calculatorgql.model.PizzaCalculatorInput;
import com.pizzaApp.pizzaBackEnd.calculatorgql.model.PizzaCalculatorOutput;
import com.pizzaApp.pizzaBackEnd.calculatorgql.service.PizzaCalculatorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("http://localhost:3000")
public class calculatorController {
    private final PizzaCalculatorService pizzaCalculatorService;

    public calculatorController(PizzaCalculatorService pizzaCalculatorService) {
        this.pizzaCalculatorService = pizzaCalculatorService;
    }

    @QueryMapping
    public PizzaCalculatorOutput getCalculation(@Argument PizzaCalculatorInput pizzaCalculatorInput) {
        return pizzaCalculatorService.pizzaCalculatorOutput(pizzaCalculatorInput);
    }
}
