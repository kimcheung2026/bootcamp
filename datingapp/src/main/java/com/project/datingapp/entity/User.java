package com.project.datingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("用戶ID，主鍵自增")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @Comment("登錄賬號，唯一不可重重複")
    private String username;

    @Column(nullable = false, length = 100)
    @Comment("登錄密碼（加密儲存）")
    private String password;

    @Column(length = 30)
    @Comment("用戶暱稱")
    private String nickname;

    @Column(columnDefinition = "TEXT")
    @Comment("用戶頭像URL")
    private String avatar;

    @Column(length = 10)
    @Comment("性别：男/女/保密")
    private String gender;

    // ==================== 这里改成生日（年月日） ====================
    @Comment("生日：yyyy-MM-dd")
    private LocalDate birthday;

    @Column(unique = true, length = 50)
    @Comment("郵箱，唯一")
    private String email;

    @Column(unique = true, length = 20)
    @Comment("手機號碼，唯一")
    private String phone;

    @Column(columnDefinition = "TEXT")
    @Comment("個人簡介")
    private String intro;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @Comment("創建時間，自动生成")
    private LocalDateTime createTime;


    public void setEmail(String email) {
    this.email = email;
    }
    public String getEmail() { //String -> return Type
    return this.email;
    }
    // 设置生日
    //user.setBirthday(LocalDate.of(2000, 5, 20));

    // 获取生日
    //LocalDate birthday = user.getBirthday();

    // 自动计算年龄（Java自带）
    //int age = Period.between(birthday, LocalDate.now()).getYears();
}