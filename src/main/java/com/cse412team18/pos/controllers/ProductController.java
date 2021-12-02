package com.cse412team18.pos.controllers;

import java.util.List;

import com.cse412team18.pos.models.ProductModel;
import com.cse412team18.pos.services.IDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IDatabaseService databaseService;

    @GetMapping("/all")
    @ResponseBody
    public List<ProductModel> getProducts() {
        return databaseService.getProducts();
    }
}
