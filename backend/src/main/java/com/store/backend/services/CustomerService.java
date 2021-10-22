/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.services;

import com.store.backend.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.backend.repositories.CustomerRepository;

/**
 *
 * @author nani_
 */

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
  
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }
    
    public Customer findByIdCard(Long idCard) {
        return customerRepository.findById(idCard).get();
    }
    
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    
}
