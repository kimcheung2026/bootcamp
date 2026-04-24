package com.project.datingapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Transient
    public int getAge() {
        if (this.birthday == null) {
            return 0;
        }
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("User ID - Primary Key")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @Comment("Login username (unique)")
    private String username;

    @Column(nullable = false, length = 100)
    @Comment("Encrypted password")
    private String password;

    @Column(length = 30)
    @Comment("Nickname")
    private String nickname;

    @Column(length = 10)
    @Comment("Gender: MALE, FEMALE, OTHER")
    private String gender;

    @Comment("Birthday yyyy-MM-dd")
    private LocalDate birthday;

    @Column(unique = true, length = 50)
    @Comment("Email")
    private String email;

    @Column(unique = true, length = 20)
    @Comment("Phone")
    private String phone;

    @Column(columnDefinition = "TEXT")
    @Comment("Introduction")
    private String intro;

    @Column(nullable = false, length = 20)
    @Comment("Role: ROLE_USER, ROLE_MERCHANT, ROLE_ADMIN")
    private String role = "ROLE_USER";

    @Column(name = "linked_merchant_id")
    @Comment("Linked merchant account ID if user has merchant role")
    private Long linkedMerchantId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @Comment("Created time")
    private LocalDateTime createTime;

    // ======================
    // 【配對系統新增欄位】
    // ======================

    @Column(length = 20)
    @Comment("Marital status: SINGLE, others")
    private String maritalStatus;

    @Column(length = 50)
    @Comment("City location for matching")
    private String city;

    @Column(length = 10)
    @Comment("MBTI personality type")
    private String mbti;

    @ElementCollection
    @Comment("User interest tags ")
    private List<String> tags;

    @Column(nullable = false)
    @Comment("Enable matching status")
    private boolean matchingEnabled = true;

    @Column(nullable = false)
    @Comment("VIP user (unlock more matching conditions)")
    private boolean isVip = false;

}