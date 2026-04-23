package com.project.datingapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_schedules")
public class CourseSchedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("時段ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", nullable = false)
  @Comment("所屬課程")
  private Course course;

  @Column(nullable = false)
  @Comment("上課日期")
  private LocalDate scheduleDate;

  @Column(nullable = false)
  @Comment("開始時間")
  private LocalTime startTime;

  @Column(nullable = false)
  @Comment("結束時間")
  private LocalTime endTime;

  @Column(length = 50)
  @Comment("地點/教室")
  private String location;

  @Column(columnDefinition = "TEXT")
  @Comment("備註")
  private String remark;

  @Column(nullable = false)
  @Comment("最大人數")
  private Integer maxCapacity;

  @Column(nullable = false)
  @Comment("已報名人數")
  private Integer enrolled = 0;

  @Column(length = 20)
  @Comment("狀態：可報名/已滿/已結束")
  private String status = "AVAILABLE";
}