package com.pizzaApp.pizzaBackEnd.order.controller;

import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.menu.repository.DrinkRepo;
import com.pizzaApp.pizzaBackEnd.menu.repository.IngredientRepo;
import com.pizzaApp.pizzaBackEnd.menu.repository.PizzaRepo;
import com.pizzaApp.pizzaBackEnd.order.model.Order;
import com.pizzaApp.pizzaBackEnd.order.model.OrderInput;
import com.pizzaApp.pizzaBackEnd.order.repository.OrderRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@Controller
@CrossOrigin("http://localhost:3000")
public class OrderController {

    private final PizzaRepo pizzaRepo;
    private final IngredientRepo ingredientRepo;
    private final DrinkRepo drinkRepo;
    private final OrderRepo orderRepo;


    public OrderController(PizzaRepo pizzaRepo, IngredientRepo ingredientRepo, DrinkRepo drinkRepo, OrderRepo orderRepo) {
        this.pizzaRepo = pizzaRepo;
        this.ingredientRepo = ingredientRepo;
        this.drinkRepo = drinkRepo;
        this.orderRepo = orderRepo;
    }

    @QueryMapping
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }


    @MutationMapping
    public Order createOrder(@Argument OrderInput orderInput) {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date currentTime = Calendar.getInstance().getTime();
        String timestamp = df.format(currentTime);

        String customerName = orderInput.customerName();
        List<String> pizzas = orderInput.pizzas();
        List<String> drinks = orderInput.drinks();

        List<Pizza> listPizzas = pizzaRepo.findByNameIn(pizzas);
        List<Drink> listDrinks = drinkRepo.findByNameIn(drinks);

        AtomicReference<Double> costRef = new AtomicReference<>(0.0);
        AtomicBoolean vegeterianRef = new AtomicBoolean(true);
        AtomicBoolean veganRef = new AtomicBoolean(true);
        AtomicBoolean alcoholicRef = new AtomicBoolean(false);

        Consumer<Pizza> pizzaConsumer = p -> {
            if (p.isVegetarian() == false) {
                vegeterianRef.set(false);
            }
            if (p.isVegan() == false) {
                veganRef.set(false);
            }
            costRef.updateAndGet(v -> v + p.getCost());
        };

        Consumer<Drink> drinkConsumer = d -> {
            if(d.isAlcoholic() == false) {
                alcoholicRef.set(true);
            }
            costRef.updateAndGet(v -> v + d.getCost());
        };

        listPizzas.stream().forEach(pizzaConsumer);
        listDrinks.stream().forEach(drinkConsumer);

        boolean alcoholic = alcoholicRef.get();
        boolean vegetarian = vegeterianRef.get();
        boolean vegan = veganRef.get();

        Float cost = costRef.get().floatValue();
        float price = (float) (Math.ceil(3*cost)-0.05);

        return orderRepo.save(new Order(timestamp, customerName, pizzas,
                drinks, price, cost, alcoholic, vegetarian, vegan));
    }
}