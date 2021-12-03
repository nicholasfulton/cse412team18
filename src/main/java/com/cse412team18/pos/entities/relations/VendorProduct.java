package com.cse412team18.pos.entities.relations;

import java.io.Serializable;

import javax.persistence.*;

import com.cse412team18.pos.entities.Product;
import com.cse412team18.pos.entities.Vendor;
import com.cse412team18.pos.entities.helpers.VendorProductId;

@Entity
@Table(name = "vendorproduct")
public class VendorProduct implements Serializable {
    @EmbeddedId
    private VendorProductId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productid")
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("vendorid")
    @JoinColumn(name = "vendorid")
    private Vendor vendor;

    public VendorProductId getId() {
        return this.id;
    }

    public void setId(VendorProductId id) {
        this.id = id;
    }

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
