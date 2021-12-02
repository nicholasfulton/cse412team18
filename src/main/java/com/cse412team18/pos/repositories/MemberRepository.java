package com.cse412team18.pos.repositories;

import com.cse412team18.pos.entities.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    
}
