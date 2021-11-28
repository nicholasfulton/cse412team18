package com.cse412team18.pos.models;

import javax.persistence.*;

@Entity
@Table(name = "`Member`")
public class Member {
    @Id
    @Column(name = "`MemberID`")
    private String memberId;
    
    @Column(name = "`CreationDate`")
    private String creationDate;

    @Column(name = "`Birthday`")
    private String birthday;

    @Column(name = "`Name`")
    private String name;
    
    @Column(name = "`PhoneNumber`")
    private String phoneNumber;

    @Column(name = "`Points`")
    private int points;

    @Column(name = "`Address`")
    private String address;

    // @ManyToMany
    // public List<Receipt> receipts;


    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
}
