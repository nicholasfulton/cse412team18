package com.cse412team18.pos.repositories;

import com.cse412team18.pos.entities.Clothing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
    
}
