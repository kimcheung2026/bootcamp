package com.project.datingapp.controller;

import java.util.Map;

import com.project.datingapp.entity.Merchant;
import com.project.datingapp.service.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant") // 建議加上路徑前綴
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    // 商家註冊 - 改用 @RequestBody 接收 JSON，並透過 Service 處理邏輯
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Merchant merchant) {
        try {
            merchantService.register(merchant);
            return ResponseEntity.ok("商家註冊成功！等待審核");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 商家登入
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");

            // 調用 Service，裡面已經包含密碼檢查與審核狀態檢查
            merchantService.login(username, password);
            return ResponseEntity.ok("登入成功！可發布課程");
        } catch (Exception e) {
            // Service 拋出的異常訊息（如：密碼錯誤、未審核）會在這裡回傳
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    // 只有審核通過才能發布內容
    @GetMapping("/publish")
    public ResponseEntity<String> publishClass(@RequestParam String username) {
        try {
            Merchant merchant = merchantService.login(username, null);
            // 範例：在 log 紀錄是哪位商家發布的
            System.out.println("商家 " + merchant.getUsername() + " 正在發布內容");

            return ResponseEntity.ok("內容發布成功！商家ID: " + merchant.getId());
        } catch (Exception e) {
            return ResponseEntity.status(403).body("無法發布：權限不足或未通過審核");
        }
    }
}