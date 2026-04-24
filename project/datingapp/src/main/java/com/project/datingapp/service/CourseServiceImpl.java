package com.project.datingapp.service;

import com.project.datingapp.entity.Course;
import com.project.datingapp.entity.CourseSchedule;
import com.project.datingapp.repository.CourseRepository;
import com.project.datingapp.repository.CourseScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseScheduleRepository courseScheduleRepository;

  @Override
  @Transactional
  @SuppressWarnings("null")
  public void saveCourseAndSchedule(Course course, CourseSchedule schedule) {
    Course saved = courseRepository.save(course);
    schedule.setCourse(saved);
    courseScheduleRepository.save(schedule);
  }
}