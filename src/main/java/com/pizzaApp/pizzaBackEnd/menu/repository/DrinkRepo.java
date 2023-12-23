package com.pizzaApp.pizzaBackEnd.menu.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
    List<Drink> findByName(String name);
    List<Drink> findByNameIn(List<String> names);
    List<Drink> findByAlcoholic(Boolean alcoholic);
}
