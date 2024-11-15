package com.lumi.customers.repository;

import com.lumi.customers.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select c from Customer c where c.email like %:email% or c.address like %:address%")
    List<Customer> findByEmailOrAddress(@Param("email") String email, @Param("address") String address);
}
