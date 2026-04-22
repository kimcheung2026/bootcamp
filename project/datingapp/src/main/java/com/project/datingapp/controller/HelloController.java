package com.project.datingapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.project.datingapp.dto.UserRegisterDTO;
import com.project.datingapp.entity.User;
import com.project.datingapp.exception.UserServiceException;
import com.project.datingapp.service.UserService; // 必須引入 Service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // 必須引入

@Controller
public class HelloController {

    @Autowired
    private UserService userService; // 改為注入 Service，不要直接用 Repository

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute UserRegisterDTO dto, RedirectAttributes redirectAttributes) { // 1. 補上
                                                                                                         // RedirectAttributes
        try {
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword()); // 傳明文給 Service，讓 Service 加密
            user.setNickname(dto.getNickname());
            user.setGender(dto.getGender());
            user.setBirthday(dto.getBirthday());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setIntro(dto.getIntro());

            // 處理頭像
            MultipartFile file = dto.getAvatarFile();
            if (file != null && !file.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                String uploadDir = System.getProperty("user.dir") + "/uploads/";
                File dest = new File(uploadDir + fileName);
                if (!dest.getParentFile().exists())
                    dest.getParentFile().mkdirs();
                file.transferTo(dest);
                user.setAvatar("/uploads/" + fileName);
            }

            // 2. 呼叫 Service 執行註冊 (包含檢查與加密)
            userService.registerUser(user);

            return "redirect:/login";

        } catch (UserServiceException e) {
            // 3. 這裡現在能正確運作了
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/register";
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "檔案上傳失敗");
            return "redirect:/register";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 注意：Thymeleaf 回傳的是 HTML 檔名，不要用中文字
    @GetMapping("/home")
    public String home() {
        return "home"; // 對應 home.html
    }

    @GetMapping("/interestClass")
    public String interestClass() {
        return "興趣班清單";
    }

    @GetMapping("/blindBoxOpen")
    public String blindBoxOpen() {
        return "隨機配對界面";
    }

    @GetMapping("/classEnrollment")
    public String classEnrollment() {
        return "報名記錄";
    }

    @GetMapping("/members")
    public String members() {
        return "使用者列表";

    }
}
