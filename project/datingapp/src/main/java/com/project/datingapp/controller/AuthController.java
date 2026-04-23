package com.project.datingapp.controller;

import java.io.IOException;

import com.project.datingapp.config.AuthPath;
import com.project.datingapp.dto.UserRegisterDTO;
import com.project.datingapp.exception.UserServiceException;
import com.project.datingapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(AuthPath.AUTH_PREFIX)
public class AuthController {

  @Autowired
  private UserService userService;

  /**
   * 顯示註冊頁面
   * 路徑：/register
   */
  @GetMapping(AuthPath.REGISTER)
  public String showRegisterPage() {
    return "register";
  }

  /**
   * 顯示登入頁面
   * 路徑：/login
   */
  @GetMapping(AuthPath.LOGIN)
  public String showLoginPage() {
    return "login";
  }

  /**
   * 處理使用者註冊請求
   * 路徑：/user/register
   */
  @PostMapping(AuthPath.USER_REGISTER) // 這裡改用 AuthPath 封裝
  public String register(
      @ModelAttribute UserRegisterDTO dto,
      RedirectAttributes redirectAttributes) {
    try {
      userService.registerUser(dto);
      redirectAttributes.addFlashAttribute("successMessage", "註冊成功，請登入");
      return AuthPath.REDIRECT_LOGIN; // 改用封裝好的重導向
    } catch (UserServiceException e) {
      redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
      return AuthPath.REDIRECT_REGISTER;
    } catch (IOException e) {
      redirectAttributes.addFlashAttribute("errorMessage", "檔案上傳失敗");
      return AuthPath.REDIRECT_REGISTER;
    }
  }
}