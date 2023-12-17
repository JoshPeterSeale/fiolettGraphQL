package com.pizzaApp.pizzaBackEnd.menu.controller;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import com.pizzaApp.pizzaBackEnd.menu.model.food.IngredientInput;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.menu.repository.IngredientRepo;
import com.pizzaApp.pizzaBackEnd.menu.repository.PizzaRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
public class IngredientController {

    private final IngredientRepo ingredientRepo;

    public IngredientController(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @QueryMapping
    public List<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }

    @MutationMapping
    public Ingredient createIngredient(@Argument IngredientInput ingredientInput){
        return ingredientRepo.save(new Ingredient(ingredientInput.name(), ingredientInput.cost(),
                ingredientInput.glutenFree(), ingredientInput.vegeterian(), ingredientInput.vegan()));
    }
}
