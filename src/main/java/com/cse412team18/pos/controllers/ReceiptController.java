package com.cse412team18.pos.controllers;

import com.cse412team18.pos.models.ReceiptModel;
import com.cse412team18.pos.services.IDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private IDatabaseService databaseService;

    @PostMapping
    public void createReceipt(@RequestBody() ReceiptModel receipt) {
        databaseService.createReceipt(receipt);
    }

    @GetMapping
    public ReceiptModel getReceipt(@Param(value = "id") int id) {
        var receipt = databaseService.getReceipt(id);

        return receipt;
    }

    @GetMapping("/next")
    public int nextId() {
        return databaseService.nextReceiptId();
    }
}
