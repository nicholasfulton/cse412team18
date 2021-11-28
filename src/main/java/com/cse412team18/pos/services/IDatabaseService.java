package com.cse412team18.pos.services;

import java.util.List;

import com.cse412team18.pos.models.*;

public interface IDatabaseService {
    List<Product> getProducts();

    void createReceipt(Receipt receipt);
}
