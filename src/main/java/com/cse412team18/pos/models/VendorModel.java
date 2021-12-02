package com.cse412team18.pos.models;

import java.util.HashSet;
import java.util.Set;

import com.cse412team18.pos.entities.Vendor;

public class VendorModel {
    public VendorModel() 
    { }

    public VendorModel(Vendor vendor, boolean includeProducts) {
        id = vendor.getVendorId();
        name = vendor.getName();
        country = vendor.getCountry();
        phoneNumber = vendor.getPhoneNumber();
        category = vendor.getCategory().clone();

        if (includeProducts) {
            products = new HashSet<>();
            for (var vendorProduct : vendor.getVendorProducts()) {
                products.add(new ProductModel(vendorProduct.getProduct(), false, false));
            }
        }
        else
            products = null;
    }

    private int id;
    
    private String name;

    private String country;

    private String phoneNumber;

    private String[] category;

    private Set<ProductModel> products;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getCategory() {
        return this.category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public Set<ProductModel> getProducts() {
        return this.products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }
}
