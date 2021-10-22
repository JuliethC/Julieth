/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.repositories;

import com.store.backend.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nani_
 */

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    
}
