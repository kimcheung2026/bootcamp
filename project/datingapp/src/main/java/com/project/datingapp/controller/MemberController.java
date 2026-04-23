package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AuthPath.MEMBER_PREFIX)
public class MemberController {
  @GetMapping(AuthPath.MEMBERS_LIST) // 完整路徑: /member/list
  public String members() {
    return "member/list";
  }

  @GetMapping("/enrollment")
  public String classEnrollment() {
    return "member/enrollment";
  }
}