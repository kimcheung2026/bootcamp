package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AuthPath.MATCH_PREFIX)
public class MatchController {

  /**
   * 開啟盲盒配對頁面
   * 路徑：/match/blindBoxOpen
   */
  @GetMapping(AuthPath.BLIND_BOX)
  public String blindBoxOpen() {
    return "match/blindBox";
  }

  /**
   * 課程配對頁面
   * 路徑：/match/course
   */
  @GetMapping(AuthPath.MATCH_COURSE)
  public String showMatchCoursePage() {
    return "match/course";
  }
}