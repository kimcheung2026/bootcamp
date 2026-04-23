package com.project.datingapp.repository;

import com.project.datingapp.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
  // 這裡可以留空，基本的增刪查改 JpaRepository 已經幫你寫好了
}