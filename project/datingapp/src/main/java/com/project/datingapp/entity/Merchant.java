package com.project.datingapp.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "app_merchants") // 資料表名同步改為商家
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("商家ID")
    private Long id;
    @Comment("團體/商家名稱")
    private String merchantName; // 團體名稱
    @Column(unique = true, length = 30)
    @Comment("商業登記證號碼 (BRN)")
    private String brNumber;
    @Comment("負責人姓名")
    private String ownerName; // 負責人
    private String phone;
    private String email;
    @Column(unique = true, nullable = false, length = 50)
    @Comment("登入帳號")
    private String username; // 帳號
    @Column(nullable = false)
    @Comment("登入密碼")
    private String password; // 密碼
    @Column(columnDefinition = "TEXT")
    private String address;
    @Comment("營業項目/簡介")
    private String business; // 營業項目
    @Comment("是否審核通過")
    private boolean isVerified; // 是否審核通過

    @Column(name = "linked_user_id")
    @Comment("Linked user account ID")
    private Long linkedUserId;

    // 無參建構子（JPA 必備）
    public Merchant() {
    }

    // getter & setter --------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getBrNumber() {
        return brNumber;
    }

    public void setBrNumber(String brNumber) {
        this.brNumber = brNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Long getLinkedUserId() {
        return linkedUserId;
    }

    public void setLinkedUserId(Long linkedUserId) {
        this.linkedUserId = linkedUserId;
    }
}