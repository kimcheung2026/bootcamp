package com.project.datingapp.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.project.datingapp.config.AuthPath;
import com.project.datingapp.entity.Course;
import com.project.datingapp.entity.CourseSchedule;
import com.project.datingapp.entity.Merchant;
import com.project.datingapp.repository.MerchantRepository;
import com.project.datingapp.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(AuthPath.COURSE_PREFIX)
public class CourseController {

  @Autowired
  private CourseService courseService;

  @Autowired
  private MerchantRepository merchantRepository;

  // ================== 打開發布頁面 ==================
  @GetMapping(AuthPath.COURSE_PUBLISH)
  public String showPublishPage() {
    return "merchant/publish_course";
  }

  // ================== 發布課程 ==================
  @PostMapping(AuthPath.COURSE_PUBLISH)
  public String publishCourse(
      @RequestParam String title,
      @RequestParam String description,
      @RequestParam BigDecimal price,
      @RequestParam(required = false) String coverImage,
      @RequestParam LocalDate scheduleDate,
      @RequestParam LocalTime startTime,
      @RequestParam LocalTime endTime,
      @RequestParam(required = false) String location,
      Authentication authentication,
      RedirectAttributes ra) {

    // 取得登入商家
    String username = authentication.getName();
    Merchant merchant = merchantRepository.findByUsername(username)
        .orElseThrow();

    // 建立課程
    Course course = new Course();
    course.setTitle(title);
    course.setDescription(description);
    course.setPrice(price);
    course.setCoverImage(coverImage);
    course.setMerchant(merchant);

    // 建立時段
    CourseSchedule schedule = new CourseSchedule();
    schedule.setScheduleDate(scheduleDate);
    schedule.setStartTime(startTime);
    schedule.setEndTime(endTime);
    schedule.setLocation(location);
    schedule.setCourse(course);

    // 儲存
    courseService.saveCourseAndSchedule(course, schedule);

    ra.addFlashAttribute("success", "課程發布成功");
    return "redirect:" + AuthPath.COURSE_PREFIX + AuthPath.COURSE_PUBLISH;
  }
}