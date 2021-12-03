package com.cse412team18.pos.entities.relations;

import java.io.Serializable;

import javax.persistence.*;

import com.cse412team18.pos.entities.Member;
import com.cse412team18.pos.entities.Receipt;
import com.cse412team18.pos.entities.helpers.MemberReceiptId;

@Entity
@Table(name = "memberreceipt")
public class MemberReceipt implements Serializable {
    @EmbeddedId
    private MemberReceiptId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("receiptid")
    @JoinColumn(name = "receiptid")
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("memberid")
    @JoinColumn(name = "memberid")
    private Member member;

    public MemberReceiptId getId() {
        return this.id;
    }

    public void setId(MemberReceiptId id) {
        this.id = id;
    }

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
