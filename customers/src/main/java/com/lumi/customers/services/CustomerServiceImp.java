package com.lumi.customers.services;

import com.lumi.customers.entities.Customer;
import com.lumi.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer(Integer id) {
       Optional<Customer> customer= repository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
      List<Customer> list= new ArrayList<>();
      Iterable<Customer> customers = repository.findAll();

      for (Customer customer : customers) {
          list.add(customer);
      }
      return list;
    }

    @Override
    public void removeCustomer(Integer id) {
    repository.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void updateCustomer(Integer id, Customer updateCustomer) {
        updateCustomer.setId(id);
    repository.save(updateCustomer);
    }

    @Override
    public List<Customer> searchCustomer(String email, String address) {
        return repository.findByEmailOrAddress(email, address);
    }
}
