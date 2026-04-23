package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasswordController {

  /**
   * 顯示忘記密碼申請頁面
   * 路徑：/forgot-password
   */
  @GetMapping(AuthPath.FORGOT_PASSWORD)
  public String showForgotPasswordPage() {
    return "forgot-password";
  }

  /**
   * 處理忘記密碼表單提交
   * 路徑：/forgot-password
   */
  @PostMapping(AuthPath.FORGOT_PASSWORD)
  public String processForgotPassword(
      @RequestParam("email") String email,
      RedirectAttributes redirectAttributes) {

    // TODO: 後續串接 Service 寄送重設信件
    // userService.sendResetPasswordEmail(email);

    redirectAttributes.addFlashAttribute("successMessage", "重設指令已發送到您的信箱！(模擬)");
    return AuthPath.REDIRECT_FORGOT_PASSWORD;
  }
}
