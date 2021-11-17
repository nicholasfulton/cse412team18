package com.cse412team18.pos.models;

import java.util.Date;
import java.util.List;

import com.cse412team18.pos.models.database.JoinedValue;
import com.cse412team18.pos.models.database.ProductOnReceipt;

public class Receipt {
    public int receiptId;
    public String paymentMethod;
    public double taxRate;
    public int subtotal;
    public int discount;
    public short creditCardDigits;
    public Date saleDate;

    public JoinedValue<List<ProductOnReceipt>> products;
    public JoinedValue<Member> member;
}
