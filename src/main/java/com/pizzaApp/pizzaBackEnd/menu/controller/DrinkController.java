package com.pizzaApp.pizzaBackEnd.menu.controller;

import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import com.pizzaApp.pizzaBackEnd.menu.model.drink.DrinkInput;
import com.pizzaApp.pizzaBackEnd.menu.model.food.IngredientInput;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.menu.repository.DrinkRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
public class DrinkController {

    private final DrinkRepo drinkRepo;

    public DrinkController(DrinkRepo drinkRepo) {
        this.drinkRepo = drinkRepo;
    }

    @QueryMapping
    public List<Drink> getDrinks() {
        return drinkRepo.findAll();
    }

    @QueryMapping
    public List<Drink> getDrinkByName(@Argument String name) {
        return drinkRepo.findByName(name);
    }

    @QueryMapping
    public List<Drink> getDrinksByNames(@Argument List<String> names) {
        return drinkRepo.findByNameIn(names);
    }

    @QueryMapping
    public List<Drink> getDrinksByAlcoholic(@Argument Boolean alcoholic) {
        return drinkRepo.findByAlcoholic(alcoholic);
    }

    @MutationMapping
    public Drink createDrink(@Argument DrinkInput drinkInput){
        return drinkRepo.save(new Drink(drinkInput.name(), drinkInput.cost(),
                drinkInput.glutenFree(), drinkInput.vegeterian(), drinkInput.vegan(), drinkInput.alcoholic()));
    }
}
