package com.pizzaApp.pizzaBackEnd.menu.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {
}
