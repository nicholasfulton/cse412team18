package com.cse412team18.pos.entities.relations;

import java.io.Serializable;

import javax.persistence.*;

import com.cse412team18.pos.entities.Member;
import com.cse412team18.pos.entities.Receipt;

@Entity
@Table(name = "memberreceipt")
public class MemberReceipt implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiptid")
    private Receipt receipt;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberid")
    private Member member;

    public Receipt getReceipt() {
        return this.receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
