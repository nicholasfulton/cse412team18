package com.cse412team18.pos.models.relations;

import javax.persistence.*;

import com.cse412team18.pos.models.Member;
import com.cse412team18.pos.models.Receipt;

@Entity
@Table(name = "`MemberReceipt`")
public class MemberReceipt {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`ReceiptID`")
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`MemberID`")
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
