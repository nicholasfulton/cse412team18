package com.cse412team18.pos.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.cse412team18.pos.entities.relations.ReceiptProduct;
import com.cse412team18.pos.entities.relations.VendorProduct;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {
    @Id
    @Column(name = "productid")
    private int productId;
    
    @Column(name = "price")
    private int price;

    @Column(name = "stockcount")
    private int stockCount;

    @Column(name = "category")
    private String category;

    @Column(name = "displayname")
    private String displayName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<VendorProduct> vendorProducts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ReceiptProduct> receiptProducts;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockCount() {
        return this.stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<VendorProduct> getVendorProducts() {
        return this.vendorProducts;
    }

    public void setVendorProducts(Set<VendorProduct> vendorProducts) {
        this.vendorProducts = vendorProducts;
    }

    public Set<ReceiptProduct> getReceiptProducts() {
        return this.receiptProducts;
    }

    public void setReceiptProducts(Set<ReceiptProduct> receiptProducts) {
        this.receiptProducts = receiptProducts;
    }
}
