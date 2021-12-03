package com.cse412team18.pos.entities.helpers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VendorProductId implements Serializable {
    @Column(name = "productid")
    private int productId;

    @Column(name = "vendorid")
    private int vendorId;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}
