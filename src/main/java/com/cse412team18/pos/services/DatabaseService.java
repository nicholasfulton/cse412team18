package com.cse412team18.pos.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.cse412team18.pos.entities.*;
import com.cse412team18.pos.entities.relations.*;
import com.cse412team18.pos.models.*;
import com.cse412team18.pos.repositories.*;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        
        Set<MemberReceipt> memberReceipts = new HashSet<>();
        // for (var member : receipt.getMembers()) {
        //     var memberReceipt = new MemberReceipt();
        //     memberReceipt.setMember(memberRepository.getById(member.getId()));
        //     memberReceipt.setReceipt(dbReceipt);

        //     memberReceipts.add(memberReceipt);
        // }

        dbReceipt.setMemberReceipts(memberReceipts);

        Set<ReceiptProduct> receiptProducts = new HashSet<>();
        // for (var receiptProduct : receipt.getProducts()) {
        //     var dbReceiptProduct = new ReceiptProduct();
        //     dbReceiptProduct.setProduct(productRepository.findById(receiptProduct.getProduct().getId()).get());
        //     dbReceiptProduct.setReceipt(dbReceipt);
        //     dbReceiptProduct.setCount(receiptProduct.getCount());

        //     receiptProducts.add(dbReceiptProduct);
        // }

        dbReceipt.setReceiptProducts(receiptProducts);

        

        receiptRepository.saveAndFlush(dbReceipt);
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
        Member example = new Member();
        example.setPhoneNumber(phoneNumber);
        var result = memberRepository.findOne(Example.of(example));
        if (result.isPresent())
            return new MemberModel(result.get(), false);
        else
            return null;
    }
}
