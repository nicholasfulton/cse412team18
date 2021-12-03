package com.cse412team18.pos.entities.helpers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberReceiptId implements Serializable {
    @Column(name = "receiptid")
    private int receiptId;

    @Column(name = "memberid")
    private int memberId;

    public int getReceiptId() {
        return this.receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
