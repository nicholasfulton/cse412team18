package com.cse412team18.pos.models.relations;

import javax.persistence.*;

import com.cse412team18.pos.models.Product;
import com.cse412team18.pos.models.Receipt;

@Entity
@Table(name = "`ReceiptProduct`")
public class ReceiptProduct {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`ReceiptID`")
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`ProductID`")
    private Product product;

    @Column(name = "`Count`")
    private int count;


    public Receipt getReceipt() {
        return this.receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
