package com.project.datingapp.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.datingapp.dto.UserRegisterDTO;
import com.project.datingapp.repository.UserRepository;

@RestController
public class HelloController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register" ;
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute com.project.datingapp.dto.UserRegisterDTO dto) {
        try {
            // 1. 创建用户对象
            User user = new User();

            // 2. 设置表单数据
            user.setUsername(dto.getUsername());
            user.setPassword(passwordEncoder.encode(dto.getPassword())); // 密码加密
            user.setNickname(dto.getNickname());
            user.setGender(dto.getGender());
            user.setBirthday(dto.getBirthday());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setIntro(dto.getIntro());

            // 3. 头像处理（如果有上传）
            MultipartFile file = dto.getAvatarFile();
            if (file != null && !file.isEmpty()) {
                // 这里先用简单文件名，你以后可以换成云存储
                String avatarUrl = "/uploads/" + file.getOriginalFilename();
                user.setAvatar(avatarUrl);
            }

            // 4. 保存到数据库
            userRepository.save(user);

            // 5. 注册成功，跳转到成功页面
            return "success";

        } catch (Exception e) {
            // 注册失败
            return "error";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "系統首頁" ;
    }

    @GetMapping("/interestClass")
    public String interestClass() {
        return "興趣班清單" ;
    }

    @GetMapping("/blindBoxOpen")
    public String blindBoxOpen() {
        return "隨機配對界面" ;
    }

    @GetMapping("/classEnrollment")
    public String classEnrollment() {
        return "報名記錄" ;
    }

    @GetMapping("/members")
    public String members() {
        return "使用者列表" ;

    }
}
