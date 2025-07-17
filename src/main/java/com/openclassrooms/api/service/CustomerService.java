package com.openclassrooms.api.service;

import java.util.Optional;

import com.openclassrooms.api.model.Customer;
import com.openclassrooms.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //One
    public Optional<Customer> getCustomer(final Long id){
        return customerRepository.findById(id);
    }

    //All
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    //Delete
    public void deleteCustomer(final Long id){
        customerRepository.deleteById(id);
    }

    //Update
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

}
