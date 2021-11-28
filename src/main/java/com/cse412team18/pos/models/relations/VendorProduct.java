package com.cse412team18.pos.models.relations;

import javax.persistence.*;

import com.cse412team18.pos.models.Product;
import com.cse412team18.pos.models.Vendor;

@Entity
@Table(name = "`VendorProduct`")
public class VendorProduct {
    @OneToOne(optional = false, mappedBy = "`Product_ProductID`", fetch = FetchType.EAGER)
    private Product product;

    @OneToOne(optional = false, mappedBy = "`Vendor_VendorID`", fetch = FetchType.EAGER)
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
