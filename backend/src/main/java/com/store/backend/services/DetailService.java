/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.services;

import com.store.backend.entities.Detail;
import com.store.backend.repositories.DetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nani_
 */

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public List<Detail> findAll() {
        return (List<Detail>) detailRepository.findAll();
    }

    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }

}
