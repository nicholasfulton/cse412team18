package com.cse412team18.pos.repositories;

import com.cse412team18.pos.entities.helpers.VendorProductId;
import com.cse412team18.pos.entities.relations.VendorProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorProductRepository extends JpaRepository<VendorProduct, VendorProductId> {
    
}
