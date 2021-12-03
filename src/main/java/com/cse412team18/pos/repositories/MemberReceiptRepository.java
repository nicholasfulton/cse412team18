package com.cse412team18.pos.repositories;

import com.cse412team18.pos.entities.helpers.MemberReceiptId;
import com.cse412team18.pos.entities.relations.MemberReceipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberReceiptRepository extends JpaRepository<MemberReceipt, MemberReceiptId> {
    
}
