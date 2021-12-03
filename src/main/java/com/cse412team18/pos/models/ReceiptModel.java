package com.cse412team18.pos.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cse412team18.pos.entities.Receipt;

public class ReceiptModel {
    public ReceiptModel() 
    { }

    public ReceiptModel(Receipt receipt, boolean includeProducts, boolean includeMembers) {
        id = receipt.getReceiptId();
        paymentMethod = receipt.getPaymentMethod();
        taxRate = receipt.getTaxRate();
        subtotal = receipt.getSubtotal();
        discount = receipt.getDiscount();
        creditCardDigits = receipt.getCreditCardDigits();
        saleDate = receipt.getSaleDate();

        if (includeProducts) {
            products = new HashSet<>();
            for (var receiptProduct : receipt.getReceiptProducts()) {
                products.add(new ReceiptProductModel(receiptProduct));
            }
        }
        else
            products = null;

        if (includeMembers) {
            members = new HashSet<>();
            for (var memberReceipt : receipt.getMemberReceipts()) {
                members.add(new MemberModel(memberReceipt.getMember(), false));
            }
        }
        else
            products = null;
    }

    private int id;

    private String paymentMethod;

    private double taxRate;

    private int subtotal;

    private int discount;

    private Short creditCardDigits;

    private Date saleDate;

    private Set<ReceiptProductModel> products;

    private Set<MemberModel> members;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Short getCreditCardDigits() {
        return this.creditCardDigits;
    }

    public void setCreditCardDigits(Short creditCardDigits) {
        this.creditCardDigits = creditCardDigits;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Set<ReceiptProductModel> getProducts() {
        return this.products;
    }

    public void setProducts(Set<ReceiptProductModel> products) {
        this.products = products;
    }

    public Set<MemberModel> getMembers() {
        return this.members;
    }

    public void setMembers(Set<MemberModel> members) {
        this.members = members;
    }
}
