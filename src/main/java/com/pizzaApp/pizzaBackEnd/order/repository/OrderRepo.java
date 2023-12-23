package com.pizzaApp.pizzaBackEnd.order.repository;

import com.pizzaApp.pizzaBackEnd.menu.model.food.Pizza;
import com.pizzaApp.pizzaBackEnd.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAllById(Iterable<Integer> integers);

    List<Order> findByCustomerName(String name);
    List<Order> findByCustomerNameIn(List<String> names);
}
