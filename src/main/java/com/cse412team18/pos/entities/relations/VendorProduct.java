package com.cse412team18.pos.entities.relations;

import java.io.Serializable;

import javax.persistence.*;

import com.cse412team18.pos.entities.Product;
import com.cse412team18.pos.entities.Vendor;

@Entity
@Table(name = "vendorproduct")
public class VendorProduct implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendorid")
    private Vendor vendor;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
