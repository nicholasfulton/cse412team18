package com.cse412team18.pos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.cse412team18.pos.entities.relations.MemberReceipt;
import com.cse412team18.pos.entities.relations.ReceiptProduct;

@Entity
@Table(name = "receipt")
public class Receipt implements Serializable {
    @Id
    @Column(name = "receiptid")
    private int receiptId;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "taxrate")
    private double taxRate;

    @Column(name = "subtotal")
    private int subtotal;

    @Column(name = "discount")
    private int discount;

    @Column(name = "creditcarddigits")
    private Short creditCardDigits;

    @Column(name = "saledate")
    private Date saleDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt")
    private Set<ReceiptProduct> receiptProducts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt")
    private Set<MemberReceipt> memberReceipts;

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

    public Set<ReceiptProduct> getReceiptProducts() {
        return this.receiptProducts;
    }

    public void setReceiptProducts(Set<ReceiptProduct> receiptProducts) {
        this.receiptProducts = receiptProducts;
    }

    public Set<MemberReceipt> getMemberReceipts() {
        return this.memberReceipts;
    }

    public void setMemberReceipts(Set<MemberReceipt> memberReceipts) {
        this.memberReceipts = memberReceipts;
    }
}
