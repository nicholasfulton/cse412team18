package com.cse412team18.pos.models;

import java.util.HashSet;
import java.util.Set;

import com.cse412team18.pos.entities.Product;

public class ProductModel {
    public ProductModel(Product product, boolean includeVendors, boolean includeReceipts) {
        id = product.getProductId();
        price = product.getPrice();
        stockCount = product.getStockCount();
        category = product.getCategory();
        displayName = product.getDisplayName();

        if (includeVendors) {
            vendors = new HashSet<>();
            for (var vendorProduct : product.getVendorProducts()) {
                vendors.add(new VendorModel(vendorProduct.getVendor(), false));
            }
        }
        else
            vendors = null;

        if (includeReceipts) {
            receipts = new HashSet<>();
            for (var receiptProduct : product.getReceiptProducts()) {
                receipts.add(new ReceiptModel(receiptProduct.getReceipt(), false, false));
            }
        }
        else
            receipts = null;
    }

    private int id;

    private int price;

    private int stockCount;

    private String category;

    private String displayName;

    private Set<VendorModel> vendors;

    private Set<ReceiptModel> receipts;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<VendorModel> getVendors() {
        return this.vendors;
    }

    public void setVendors(Set<VendorModel> vendors) {
        this.vendors = vendors;
    }

    public Set<ReceiptModel> getReceipts() {
        return this.receipts;
    }

    public void setReceipts(Set<ReceiptModel> receipts) {
        this.receipts = receipts;
    }
}
