package com.pizzaApp.pizzaBackEnd.menu.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByName(String name);
    List<Ingredient> findByNameIn(List<String> names);
    List<Ingredient> findByVegetarian(Boolean vegetarian);
    List<Ingredient> findByVegan(Boolean vegan);
}
