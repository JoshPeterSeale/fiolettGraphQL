package com.pizzaApp.pizzaBackEnd.calculator.controller;

import com.pizzaApp.pizzaBackEnd.calculator.model.PizzaCalculatorInput;
import com.pizzaApp.pizzaBackEnd.calculator.model.PizzaCalculatorOutput;
import com.pizzaApp.pizzaBackEnd.calculator.service.PizzaCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class PizzaCalculatorController {

    private final PizzaCalculatorService pizzaCalculatorService;

    public PizzaCalculatorController(PizzaCalculatorService pizzaCalculatorService) {
        this.pizzaCalculatorService = pizzaCalculatorService;
    }


    @GetMapping(value = "/calculator")
    public PizzaCalculatorOutput getPizzaCalculation(@RequestParam double hydration,
                                                     @RequestParam double saltPercentage,
                                                     @RequestParam double doughMass,
                                                     @RequestParam int numberDoughBalls,
                                                     @RequestParam String method) {

        PizzaCalculatorInput input = new PizzaCalculatorInput(hydration, saltPercentage, doughMass, numberDoughBalls, method);
        PizzaCalculatorOutput output = pizzaCalculatorService.pizzaCalculator(input);
        return output;
        //localhost:8080/api/calculator?hydration=0.7&saltPercentage=0.025&doughMass=250&numberDoughBalls=5&met/hod=Autolyse
    }
}
