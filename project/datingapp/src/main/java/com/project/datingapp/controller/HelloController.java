package com.project.datingapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.project.datingapp.dto.UserRegisterDTO;
import com.project.datingapp.entity.User;
import com.project.datingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller; // 改用 @Controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller // 注意：若要跳轉頁面，不能用 @RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 顯示註冊頁面 (回傳 register.html)
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // 使用者註冊邏輯
    @PostMapping("/user/register")
    public String register(@ModelAttribute UserRegisterDTO dto) {
        try {
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setNickname(dto.getNickname());
            user.setGender(dto.getGender());
            user.setBirthday(dto.getBirthday());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setIntro(dto.getIntro());

            // 頭像存儲邏輯 (範例：存到本地專案目錄)
            MultipartFile file = dto.getAvatarFile();
            if (file != null && !file.isEmpty()) {
                // 使用 UUID 避免檔名重複
                String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                String uploadDir = System.getProperty("user.dir") + "/uploads/";

                File dest = new File(uploadDir + fileName);
                if (!dest.getParentFile().exists())
                    dest.getParentFile().mkdirs();

                file.transferTo(dest); // 實際存檔
                user.setAvatar("/uploads/" + fileName);
            }

            userRepository.save(user);
            return "redirect:/home"; // 註冊成功後導向首頁

        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "系統首頁";
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
