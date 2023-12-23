package com.pizzaApp.pizzaBackEnd.order.repository;

import com.pizzaApp.pizzaBackEnd.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
