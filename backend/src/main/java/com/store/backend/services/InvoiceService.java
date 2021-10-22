/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.backend.services;

import com.store.backend.entities.Invoice;
import com.store.backend.repositories.InvoiceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nani_
 */

@Service
public class InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    
}
