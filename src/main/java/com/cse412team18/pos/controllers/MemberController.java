package com.cse412team18.pos.controllers;

import com.cse412team18.pos.models.MemberModel;
import com.cse412team18.pos.services.IDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private IDatabaseService databaseService;

    @GetMapping
    @ResponseBody
    public MemberModel getMember(@Param(value = "phoneNumber") String phoneNumber) {
        return databaseService.getMember(phoneNumber);
    }
}
