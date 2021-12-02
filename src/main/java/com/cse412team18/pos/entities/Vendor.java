package com.cse412team18.pos.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.cse412team18.pos.entities.relations.VendorProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "vendor")
@TypeDef(
    name = "string-array", 
    typeClass = StringArrayType.class
)
public class Vendor implements Serializable {
    @Id
    @Column(name = "vendorid")
    private int vendorId;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "country", columnDefinition = "text")
    private String country;

    @Column(name = "phonenumber", columnDefinition = "text")
    private String phoneNumber;

    @Type(type = "string-array")
    @Column(name = "category", columnDefinition = "text[]")
    private String[] category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendor")
    @JsonIgnore
    private Set<VendorProduct> vendorProducts;

    public int getVendorId() {
        return this.vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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

    public Set<VendorProduct> getVendorProducts() {
        return this.vendorProducts;
    }

    public void setVendorProducts(Set<VendorProduct> vendorProducts) {
        this.vendorProducts = vendorProducts;
    }

    public Set<Product> getProducts() {
        Set<Product> products = new HashSet<>();
        for (var vendorProduct : vendorProducts) {
            products.add(vendorProduct.getProduct());
        }
        return products;
    }
}
