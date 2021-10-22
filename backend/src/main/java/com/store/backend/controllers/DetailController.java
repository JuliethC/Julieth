/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.controllers;

import com.store.backend.entities.Detail;
import com.store.backend.services.DetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nani_
 */

@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class DetailController {
    
    @Autowired
    private DetailService detailService;
    
    @GetMapping
    public List<Detail> findAll() {
        return detailService.findAll();
    }
    
    @PostMapping
    public Detail save(@RequestBody Detail detail) {
        return detailService.save(detail);
    }
    
}
