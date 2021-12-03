package com.cse412team18.pos.entities.helpers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReceiptProductId implements Serializable {
    @Column(name = "productid")
    private int productId;

    @Column(name = "receiptid")
    private int receiptId;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReceiptId() {
        return this.receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }
}
