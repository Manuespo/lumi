package com.lumi.customers.controllers;

import com.lumi.customers.entities.Customer;
import com.lumi.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customer/{id}")
    public Customer getCustomer (@PathVariable int id) {
        return service.getCustomer(id);
    }
    @GetMapping("/customer")
    public List<Customer> getAllCustomers () {
        return service.getAllCustomers();
    }
    @PostMapping("/customer")
    public void addCustomer (@RequestBody Customer customer) {
        service.addCustomer(customer);
    }
    @DeleteMapping("/customer/{id}")
    public void removeCustomer (@PathVariable int id) {
        service.removeCustomer(id);
    }
    @PutMapping("/customer/{id}")
    public void updateCustomer (@PathVariable Integer id, @RequestBody Customer updateCustomer) {
        service.updateCustomer(id, updateCustomer);
    }
    @GetMapping("/customer/search")
    public List<Customer> searchCustomer (@RequestParam (name= "email", required=false) String email,
                                          @RequestParam (name= "address", required=false) String address) {
        return service.searchCustomer(email,address);
    }

}
