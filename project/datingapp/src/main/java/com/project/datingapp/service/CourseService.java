package com.project.datingapp.service;

import com.project.datingapp.entity.Course;
import com.project.datingapp.entity.CourseSchedule;

public interface CourseService {
  void saveCourseAndSchedule(Course course, CourseSchedule schedule);
}