package com.cse412team18.pos.services;

import java.util.ArrayList;
import java.util.List;

import com.cse412team18.pos.models.*;

public class MockDatabaseService implements IDatabaseService {

    public List<Product> getProducts() {
        var list = new ArrayList<Product>();

        list.add(new Food() {{
            productId = 1;
            displayName = "Pringles";
            category = "food";
            allergens = new String[] { "soy" };
            stockCount = 15;
            calories = 500;
            vendor = new Vendor() {{
                vendorId = 1;
                name = "Frito-Lay";
                country = "USA";
                phoneNumber = "+11234567890";
            }};
            price = 500;

        }});

        return list;
    }

    public void createReceipt(Receipt receipt) {
        // TODO: implement
    }
    
}
