package com.project.datingapp.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;

@Data
public class UserRegisterDTO {
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String intro;
    private MultipartFile avatarFile; // 头像文件
}