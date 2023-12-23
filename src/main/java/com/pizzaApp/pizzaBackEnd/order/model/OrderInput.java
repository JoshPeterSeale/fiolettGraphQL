package com.pizzaApp.pizzaBackEnd.order.model;

import java.util.List;

public record OrderInput(String customerName,List<String> pizzas, List<String> drinks) {
}
