package com.cse412team18.pos.models;

import java.util.HashSet;
import java.util.Set;

import com.cse412team18.pos.entities.Member;

public class MemberModel {
    public MemberModel()
    { }

    public MemberModel(Member member, boolean includeReceipts) {
        id = member.getMemberId();
        creationDate = member.getCreationDate();
        birthday = member.getBirthday();
        name = member.getName();
        phoneNumber = member.getPhoneNumber();
        points = member.getPoints();
        address = member.getAddress();

        if (includeReceipts) {
            receipts = new HashSet<>();
            for (var memberReceipt : member.getMemberReceipts()) {
                receipts.add(new ReceiptModel(memberReceipt.getReceipt(), true, false));
            }
        }
        else
            receipts = null;
    }

    private int id;
    
    private String creationDate;

    private String birthday;

    private String name;

    private String phoneNumber;

    private int points;

    private String address;

    private Set<ReceiptModel> receipts;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ReceiptModel> getReceipts() {
        return this.receipts;
    }

    public void setReceipts(Set<ReceiptModel> receipts) {
        this.receipts = receipts;
    }
}
