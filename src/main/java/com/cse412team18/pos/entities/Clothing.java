package com.cse412team18.pos.entities;

import javax.persistence.*;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "clothing")
@TypeDef(
    name = "string-array", 
    typeClass = StringArrayType.class
)
public class Clothing extends Product {
    @Column(name = "style")
    public String style;

    @Type(type = "string-array")
    @Column(name = "availablesizes")
    public String[] availableSizes;

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String[] getAvailableSizes() {
        return this.availableSizes;
    }

    public void setAvailableSizes(String[] availableSizes) {
        this.availableSizes = availableSizes;
    }
}
