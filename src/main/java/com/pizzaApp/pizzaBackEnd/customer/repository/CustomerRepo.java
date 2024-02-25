package com.pizzaApp.pizzaBackEnd.customer.repository;

import com.pizzaApp.pizzaBackEnd.customer.model.Customer;
import com.pizzaApp.pizzaBackEnd.customer.model.CustomerInput;
import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import com.pizzaApp.pizzaBackEnd.order.model.Order;
import com.pizzaApp.pizzaBackEnd.order.model.OrderInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String name);
    List<Customer> findByLastName(String name);
    @Query("SELECT c FROM Customer c WHERE CONCAT(c.firstName, ' ', c.lastName) = :fullName")
    List<Customer> findByFullName(@Param("fullName") String name);
    List<Customer> findByEmailAddress(String emailAddress);
}
