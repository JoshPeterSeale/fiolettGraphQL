package com.pizzaApp.pizzaBackEnd.menu.model.food;

import java.util.List;

public record PizzaInput(String name, List<String> ingredients) {
}
