package com.cse412team18.pos.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.cse412team18.pos.entities.relations.MemberReceipt;

@Entity
@Table(name = "member")
public class Member implements Serializable {
    @Id
    @Column(name = "memberid")
    private String memberId;
    
    @Column(name = "creationdate")
    private String creationDate;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "name")
    private String name;
    
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "points")
    private int points;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private Set<MemberReceipt> memberReceipts;

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

    public Set<MemberReceipt> getMemberReceipts() {
        return this.memberReceipts;
    }

    public void setMemberReceipts(Set<MemberReceipt> memberReceipts) {
        this.memberReceipts = memberReceipts;
    }
}
