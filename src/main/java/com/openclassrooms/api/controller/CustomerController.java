package com.openclassrooms.api.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Customer;
import com.openclassrooms.api.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Read all customers
    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //Read one customer
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") final Long id) {
        Optional<Customer> customer = customerService.getCustomer(id);
        return customer.orElse(null);
    }

    //Create a new customer
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    //Delete a customer
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") final Long id){
        customerService.deleteCustomer(id);
    }

    //Update a customer
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable("id") final Long id, @RequestBody Customer customer) {
        Optional<Customer> c = customerService.getCustomer(id);
        if(c.isPresent()) {
            Customer currentCustomer = c.get();

            String firstName = customer.getFirstName();
            if(firstName != null) {
                currentCustomer.setFirstName(firstName);
            }

            String lastName = customer.getLastName();
            if(lastName != null) {
                currentCustomer.setLastName(lastName);
            }

            String birthDate = customer.getBirthDate();
            if(birthDate != null)
                currentCustomer.setBirthDate(birthDate);

            customerService.saveCustomer(currentCustomer);
            return  currentCustomer;
        } else {
            return null;
        }
    }
}
