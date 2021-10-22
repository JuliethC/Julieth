/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.controllers;

import static com.store.backend.JwtAuthorizationFilter.KEY;
import static com.store.backend.JwtAuthorizationFilter.PREFIX;
import com.store.backend.entities.Customer;
import com.store.backend.services.CustomerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nani_
 */

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    
    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
    
    @PostMapping("login")
    public Object login(@RequestParam Long idCard, @RequestParam String password) {
        Customer customer = customerService.findByIdCard(idCard);
        return customer == null ? null : customerAuthorization(customer);
    }
    
    private Object customerAuthorization(Customer customer) {
        return new Object() {

            public Customer getCustomer() {
                return customer;
            }
 
            public String getToken() {
                return generateToken(customer.getIdCard());
            }

        };
    }
 
    private String generateToken(Long idCard) {
        long currentTimeMillis = System.currentTimeMillis();
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        return PREFIX + Jwts
                .builder()
                .setId(currentTimeMillis + ":" + idCard)
                .setSubject(idCard.toString())
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        KEY.getBytes()).compact();
    }
    
}
