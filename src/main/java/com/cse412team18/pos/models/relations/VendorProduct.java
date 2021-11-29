package com.cse412team18.pos.models.relations;

import javax.persistence.*;

import com.cse412team18.pos.models.Product;
import com.cse412team18.pos.models.Vendor;

@Entity
@Table(name = "`VendorProduct`")
public class VendorProduct {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Product_ProductID`")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Vendor_VendorID`")
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
