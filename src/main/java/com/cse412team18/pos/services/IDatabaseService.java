package com.cse412team18.pos.services;

import java.util.List;

import com.cse412team18.pos.models.*;

public interface IDatabaseService {
    int nextReceiptId();

    void createReceipt(ReceiptModel receipt);

    ReceiptModel getReceipt(int id);

    List<VendorModel> getVendors();

    List<ProductModel> getProducts();

    MemberModel getMember(String phoneNumber);
}
