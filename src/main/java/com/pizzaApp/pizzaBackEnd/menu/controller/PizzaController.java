package com.pizzaApp.pizzaBackEnd.menu.controller;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.menu.model.food.PizzaInput;
import com.pizzaApp.pizzaBackEnd.menu.repository.IngredientRepo;
import com.pizzaApp.pizzaBackEnd.menu.repository.PizzaRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@Controller
@CrossOrigin("http://localhost:3000")
public class PizzaController {

    private final PizzaRepo pizzaRepo;
    private final IngredientRepo ingredientRepo;

    public PizzaController(PizzaRepo pizzaRepo, IngredientRepo ingredientRepo) {
        this.pizzaRepo = pizzaRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @QueryMapping
    public List<Pizza> getPizzas() {
        return pizzaRepo.findAll();
    }

    @MutationMapping
    public Pizza createPizza(@Argument PizzaInput pizzaInput){

        AtomicReference<Double> costRef = new AtomicReference<>(0.0);
        AtomicBoolean glutenFreeRef = new AtomicBoolean(true);
        AtomicBoolean vegeterianRef = new AtomicBoolean(true);
        AtomicBoolean veganRef = new AtomicBoolean(true);

        Consumer<Ingredient> consumer = e -> {
            if (e.isGlutenFree() == false) {
                glutenFreeRef.set(false);
            }
            if (e.isVegetarian() == false) {
                vegeterianRef.set(false);
            }
            if (e.isVegan() == false) {
                veganRef.set(false);
            }
            costRef.updateAndGet(v -> v + e.getCost());
        };

        List<String> ingredientNames = pizzaInput.ingredients();
        List<Ingredient> allIngredients = ingredientRepo.findAll();
        allIngredients.stream()
                .filter(e -> ingredientNames.contains(e.getName()))
                .forEach(consumer);

        boolean glutenFree = glutenFreeRef.get();
        boolean vegetarian = vegeterianRef.get();
        boolean vegan = veganRef.get();
        double cost = costRef.get();
        float price = (float) (Math.ceil(3*cost)-0.05);

        return pizzaRepo.save(new Pizza(pizzaInput.name(),pizzaInput.ingredients(), price, glutenFree, vegetarian, vegan));
    }
}
