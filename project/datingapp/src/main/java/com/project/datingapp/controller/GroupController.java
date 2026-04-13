package com.project.datingapp.controller;

import com.project.datingapp.entity.Group;
import com.project.datingapp.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 團體註冊
    @PostMapping("/group/register")
    public String groupRegister(
            @RequestParam String groupName,
            @RequestParam String taxId,
            @RequestParam String ownerName,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String address,
            @RequestParam String business
    ) {
        Group group = new Group();
        group.setGroupName(groupName);
        group.setTaxId(taxId);
        group.setOwnerName(ownerName);
        group.setPhone(phone);
        group.setEmail(email);
        group.setUsername(username);
        group.setPassword(passwordEncoder.encode(password));
        group.setAddress(address);
        group.setBusiness(business);
        group.setVerified(false); // 預設未審核

        groupRepository.save(group);
        return "團體註冊成功！等待審核";
    }

    // 團體登入
    @PostMapping("/group/login")
    public String groupLogin(
            @RequestParam String username,
            @RequestParam String password
    ) {
        Group group = groupRepository.findByUsername(username);

        if (group == null) {
            return "帳號錯誤";
        }

        if (!passwordEncoder.matches(password, group.getPassword())) {
            return "密碼錯誤";
        }

        if (!group.isVerified()) {
            return "未通過審核，無法發布課程";
        }

        return "登入成功！可發布課程";
    }

    // 只有審核通過才能發布班級
    @GetMapping("/group/publish")
    public String publishClass(@RequestParam String username) {
        Group group = groupRepository.findByUsername(username);

        if (group == null || !group.isVerified()) {
            return "無法發布課程";
        }

        return "課程發布成功！";
    }
}