package com.project.datingapp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("課程ID")
  private Long id;

  @Column(nullable = false, length = 100)
  @Comment("課程標題")
  private String title;

  @Column(columnDefinition = "TEXT")
  @Comment("課程描述")
  private String description;

  // ===================== 【修正】金額用 BigDecimal =====================
  @Column(nullable = false, precision = 10, scale = 2)
  @Comment("課程價格")
  private BigDecimal price;

  @Column(length = 255)
  @Comment("課程封面圖片URL")
  private String coverImage;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  @Comment("發布時間")
  private LocalDateTime createTime;

  // ===================== 商家關聯（正確） =====================
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id", nullable = false)
  @Comment("所屬商家")
  private Merchant merchant;

  // ===================== 課程時間表（正確） =====================
  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<CourseSchedule> schedules;
}