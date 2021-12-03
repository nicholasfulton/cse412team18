package com.cse412team18.pos.entities.relations;

import java.io.Serializable;

import javax.persistence.*;

import com.cse412team18.pos.entities.Product;
import com.cse412team18.pos.entities.Receipt;
import com.cse412team18.pos.entities.helpers.ReceiptProductId;

@Entity
@Table(name = "receiptproduct")
public class ReceiptProduct implements Serializable {
    @EmbeddedId
    private ReceiptProductId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("receiptid")
    @JoinColumn(name = "receiptid")
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productid")
    @JoinColumn(name = "productid")
    private Product product;

    @Column(name = "count")
    private int count;

    public ReceiptProductId getId() {
        return this.id;
    }

    public void setId(ReceiptProductId id) {
        this.id = id;
    }

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
