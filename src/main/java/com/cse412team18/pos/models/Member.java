package com.cse412team18.pos.models;

import java.util.List;

import com.cse412team18.pos.models.database.JoinedValue;

public class Member {
    public String memberId;
    public String creationDate;
    public String birthday;
    public String name;
    public String phoneNumber;
    public int points;
    public String address;

    public JoinedValue<List<Receipt>> receipts;
}
