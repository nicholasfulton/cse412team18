package com.cse412team18.pos.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
}
