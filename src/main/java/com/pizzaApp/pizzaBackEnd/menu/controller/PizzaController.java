package com.pizzaApp.pizzaBackEnd.menu.controller;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.menu.model.food.PizzaInput;
import com.pizzaApp.pizzaBackEnd.menu.repository.PizzaRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
public class PizzaController {

    private final PizzaRepo pizzaRepo;

    public PizzaController(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @QueryMapping
    public List<Pizza> getPizzas() {
        return pizzaRepo.findAll();
    }

    @MutationMapping
    public Pizza createPizza(@Argument PizzaInput pizzaInput){
        return pizzaRepo.save(new Pizza(pizzaInput.name(),pizzaInput.ingredients()));
    }
}
