package com.pizzaApp.pizzaBackEnd.menu.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
    List<Pizza> findByName(String name);
    List<Pizza> findByNameIn(List<String> names);

}
