package com.cse412team18.pos.models;

import javax.persistence.*;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "`Food`")
@TypeDef(
    name = "string-array", 
    typeClass = StringArrayType.class
)
public class Food extends Product {
    @Column(name = "`Calories`")
    public int calories;

    @Type(type = "string-array")
    @Column(name = "`Allergens`")
    public String[] allergens;


    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String[] getAllergens() {
        return this.allergens;
    }

    public void setAllergens(String[] allergens) {
        this.allergens = allergens;
    }
}
