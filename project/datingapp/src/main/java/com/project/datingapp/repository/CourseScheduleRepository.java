package com.project.datingapp.repository;

import com.project.datingapp.entity.CourseSchedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
}