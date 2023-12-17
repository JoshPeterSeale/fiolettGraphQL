package com.pizzaApp.pizzaBackEnd.menu.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
}
