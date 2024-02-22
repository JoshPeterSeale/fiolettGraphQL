package com.pizzaApp.pizzaBackEnd.customer.controller;

import com.pizzaApp.pizzaBackEnd.customer.model.Customer;
import com.pizzaApp.pizzaBackEnd.customer.model.CustomerInput;
import com.pizzaApp.pizzaBackEnd.customer.repository.CustomerRepo;
import com.pizzaApp.pizzaBackEnd.menu.model.drink.Drink;
import com.pizzaApp.pizzaBackEnd.order.model.Order;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @QueryMapping
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @QueryMapping
    public Optional<Customer> getCustomerByCustomerId(Integer customerID) {
        return customerRepo.findById(customerID);
    }

    @QueryMapping
    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepo.findByFirstName(firstName);
    }

    @QueryMapping
    public List<Customer> getCustomerByLastName(String lastName) {
        return customerRepo.findByLastName(lastName);
    }

    @QueryMapping
    public List<Customer> getCustomerByEmailAddress(String emailAddress) {
        return customerRepo.findByEmailAddress(emailAddress);
    }

    @QueryMapping
    public List<Customer> getCustomerByFullName(String fullName) {
        return customerRepo.findByFullName(fullName);
    }

    @MutationMapping
    public Customer newCustomer(@Argument CustomerInput customerInput) {
        Integer numberOfOrders = 0; // to do
        return customerRepo.save(new Customer(customerInput.firstName(), customerInput.lastName(), customerInput.emailAddress(), numberOfOrders));
    }
}

