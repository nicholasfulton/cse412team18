package com.cse412team18.pos.models;

import com.cse412team18.pos.models.database.JoinedValue;

public class Product {
    public int productId;
    public int price;
    public int stockCount;
    public String category;
    public String displayName;

    public JoinedValue<Vendor> vendor;
}
