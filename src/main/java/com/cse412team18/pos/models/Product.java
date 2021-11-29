package com.cse412team18.pos.models;

import javax.persistence.*;

import com.cse412team18.pos.models.relations.ReceiptProduct;
import com.cse412team18.pos.models.relations.VendorProduct;

@Entity
@Table(name = "`Product`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @Column(name = "`ProductID`")
    private int productId;
    
    @Column(name = "`Price`")
    private int price;

    @Column(name = "`StockCount`")
    private int stockCount;

    @Column(name = "`Category`")
    private String category;

    @Column(name = "`DisplayName`")
    private String displayName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public VendorProduct[] vendorProducts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public ReceiptProduct[] receiptProducts;

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
}
