package com.cse412team18.pos.models;

import java.util.List;

import com.cse412team18.pos.models.database.JoinedValue;

public class Vendor {
    public int vendorId;
    public String name;
    public String country;
    public String phoneNumber;
    public String[] category;

    public JoinedValue<List<Product>> products;
}
