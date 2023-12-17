package com.pizzaApp.pizzaBackEnd.menu.model.drink;

public record DrinkInput(String name, float cost, boolean glutenFree, boolean vegeterian, boolean vegan, boolean alcoholic) {
}
