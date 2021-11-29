package com.cse412team18.pos.models;

import java.util.Date;

import javax.persistence.*;

import com.cse412team18.pos.models.relations.MemberReceipt;
import com.cse412team18.pos.models.relations.ReceiptProduct;

@Entity
@Table(name = "`Receipt`")
public class Receipt {
    @Id
    @Column(name = "`ReceiptID`")
    private int receiptId;

    @Column(name = "`PaymentMethod`")
    private String paymentMethod;

    @Column(name = "`TaxRate`")
    private double taxRate;

    @Column(name = "`Subtotal`")
    private int subtotal;

    @Column(name = "`Discount`")
    private int discount;

    @Column(name = "`CreditCardDigits`")
    private short creditCardDigits;

    @Column(name = "`SaleDate`")
    private Date saleDate;

    @OneToMany(fetch = FetchType.EAGER)
    public ReceiptProduct[] products;

    @OneToMany(fetch = FetchType.EAGER)
    public MemberReceipt[] member;

    public int getReceiptId() {
        return this.receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
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

    public short getCreditCardDigits() {
        return this.creditCardDigits;
    }

    public void setCreditCardDigits(short creditCardDigits) {
        this.creditCardDigits = creditCardDigits;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
}
