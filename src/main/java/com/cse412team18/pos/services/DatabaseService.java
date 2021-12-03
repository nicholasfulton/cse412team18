package com.cse412team18.pos.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.cse412team18.pos.entities.*;
import com.cse412team18.pos.entities.helpers.MemberReceiptId;
import com.cse412team18.pos.entities.helpers.ReceiptProductId;
import com.cse412team18.pos.entities.relations.*;
import com.cse412team18.pos.models.*;
import com.cse412team18.pos.repositories.*;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DatabaseService implements IDatabaseService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ClothingRepository clothingRepository;
    @Autowired
    private ReceiptProductRepository receiptProductRepository;
    @Autowired
    private VendorProductRepository vendorProductRepository;
    @Autowired
    private MemberReceiptRepository memberReceiptRepository;

    public int nextReceiptId() {
        int max = 0;
        var receipts = receiptRepository.findAll();
        for (var receipt : receipts) {
            if (receipt.getReceiptId() > max)
                max = receipt.getReceiptId();
        }
        
        return max + 1;
    }

    public void createReceipt(ReceiptModel receipt) {
        var dbReceipt = new Receipt();
        dbReceipt.setReceiptId(receipt.getId());
        dbReceipt.setPaymentMethod(receipt.getPaymentMethod());
        dbReceipt.setTaxRate(receipt.getTaxRate());
        dbReceipt.setDiscount(receipt.getDiscount());
        dbReceipt.setCreditCardDigits(receipt.getCreditCardDigits());
        dbReceipt.setSubtotal(receipt.getSubtotal());
        dbReceipt.setSaleDate(receipt.getSaleDate());

        receiptRepository.saveAndFlush(dbReceipt);
        
        for (var member : receipt.getMembers()) {
            var memberReceiptId = new MemberReceiptId();
            memberReceiptId.setMemberId(member.getId());
            memberReceiptId.setReceiptId(dbReceipt.getReceiptId());
 
            var dbMemberReceipt = new MemberReceipt();
            dbMemberReceipt.setId(memberReceiptId);

            memberReceiptRepository.saveAndFlush(dbMemberReceipt);
        }

        for (var receiptProduct : receipt.getProducts()) {
            var receiptProductId = new ReceiptProductId();
            receiptProductId.setProductId(receiptProduct.getProduct().getId());
            receiptProductId.setReceiptId(dbReceipt.getReceiptId());

            var dbReceiptProduct = new ReceiptProduct();
            dbReceiptProduct.setId(receiptProductId);
            dbReceiptProduct.setCount(receiptProduct.getCount());

            receiptProductRepository.saveAndFlush(dbReceiptProduct);
        }
    }

    public List<ProductModel> getProducts() {
        var productsFound = productRepository.findAll();
        List<ProductModel> productModels = new ArrayList<>();
        for (var productFound : productsFound) {
            Hibernate.initialize(productFound);
            productModels.add(new ProductModel(productFound, true, false));
        }
        return productModels;
    }

    public List<VendorModel> getVendors() {
        var vendorsFound = vendorRepository.findAll();
        List<VendorModel> vendorModels = new ArrayList<>();
        for (var vendorFound : vendorsFound) {
            Hibernate.initialize(vendorFound);
            vendorModels.add(new VendorModel(vendorFound, true));
        }
        return vendorModels;
    }

    public MemberModel getMember(String phoneNumber) {
        var members = memberRepository.findAll();
        for (var member : members) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                Hibernate.initialize(member);
                return new MemberModel(member, false);
            }
        }
        
        return null;
    }
}
