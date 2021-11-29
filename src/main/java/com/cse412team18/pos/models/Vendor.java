package com.cse412team18.pos.models;

import javax.persistence.*;

import com.cse412team18.pos.models.relations.VendorProduct;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "`Vendor`")
@TypeDef(
    name = "string-array", 
    typeClass = StringArrayType.class
)
public class Vendor {
    @Id
    @Column(name = "`VendorID`")
    private int vendorId;

    @Column(name = "`Name`", columnDefinition = "text")
    private String name;

    @Column(name = "`Country`", columnDefinition = "text")
    private String country;

    @Column(name = "`PhoneNumber`", columnDefinition = "text")
    private String phoneNumber;
    
    @Type(type = "string-array")
    @Column(name = "`Category`", columnDefinition = "text[]")
    private String[] category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendor")
    public VendorProduct[] vendorProducts;

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
}
