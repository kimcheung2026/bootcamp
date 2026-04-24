package com.project.datingapp.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_preference")
public class UserPreference {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("Primary Key")
  private Long id;

  @Column(nullable = false, unique = true)
  @Comment("Bound user id")
  private Long userId;

  // ========== 硬性擇偶條件 ==========
  @Comment("Minimum preferred age")
  private Integer preferredAgeMin;

  @Comment("Maximum preferred age")
  private Integer preferredAgeMax;

  @Column(length = 10)
  @Comment("Preferred gender : MALE / FEMALE / ANY")
  private String preferredGender;

  @Column(length = 50)
  @Comment("Preferred city")
  private String preferredCity;

  @Column(length = 10)
  @Comment("Preferred MBTI type")
  private String preferredMbti;

  // ========== 彈性加分條件 (標籤清單) ==========
  @ElementCollection
  @Comment("Required interest / hobby tags")
  private List<String> preferredTags;

  // ========== 排斥黑名單 (不配對) ==========
  @ElementCollection
  @Comment("Exclude tags, no match")
  private List<String> excludeTags;
}