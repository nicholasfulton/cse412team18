package com.cse412team18.pos.repositories;

import com.cse412team18.pos.entities.helpers.ReceiptProductId;
import com.cse412team18.pos.entities.relations.ReceiptProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptProductRepository extends JpaRepository<ReceiptProduct, ReceiptProductId> {
    
}
