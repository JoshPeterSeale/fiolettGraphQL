package com.pizzaApp.pizzaBackEnd.menu.model.food;

import java.util.List;

public record IngredientInput(String name, float cost, boolean glutenFree, boolean vegeterian, boolean vegan) {
}
