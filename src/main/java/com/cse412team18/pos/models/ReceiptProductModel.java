package com.cse412team18.pos.models;

import com.cse412team18.pos.entities.relations.ReceiptProduct;

public class ReceiptProductModel {
    public ReceiptProductModel() 
    { }

    public ReceiptProductModel(ReceiptProduct receiptProduct) {
        product = new ProductModel(receiptProduct.getProduct(), false, false);
        count = receiptProduct.getCount();
    }

    private ProductModel product;

    private int count;

    public ProductModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
