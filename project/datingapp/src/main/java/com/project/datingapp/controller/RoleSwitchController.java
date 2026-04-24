package com.project.datingapp.controller;

import com.project.datingapp.config.AuthPath;
import com.project.datingapp.dto.RoleSwitchDTO;
import com.project.datingapp.service.RoleSwitchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleSwitchController {

    @Autowired
    private RoleSwitchService roleSwitchService;

    /**
     * Show role switch page
     */
    @GetMapping(AuthPath.ROLE_SWITCH)
    public String showSwitchPage() {
        return "role/switch";
    }

    /**
     * Get current role
     */
    @GetMapping(AuthPath.ROLE_CURRENT)
    @ResponseBody
    public ResponseEntity<String> getCurrentRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.badRequest().body("Not authenticated");
        }

        String username = authentication.getName();
        String role = roleSwitchService.getCurrentRole(username);
        return ResponseEntity.ok(role);
    }

    /**
     * Switch role API
     */
    @PostMapping(AuthPath.ROLE_SWITCH)
    @ResponseBody
    public ResponseEntity<String> switchRole(@RequestBody RoleSwitchDTO dto) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return ResponseEntity.badRequest().body("Not authenticated");
            }

            // Use current authenticated username
            dto.setUsername(authentication.getName());
            
            String result = roleSwitchService.switchRole(dto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to switch role: " + e.getMessage());
        }
    }

    /**
     * Redirect to appropriate dashboard based on role
     */
    @GetMapping(AuthPath.ROLE_DASHBOARD)
    public String redirectToDashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return AuthPath.REDIRECT_LOGIN;
        }

        String username = authentication.getName();
        String role = roleSwitchService.getCurrentRole(username);

        if (role.equals("ROLE_MERCHANT")) {
            return "redirect:" + AuthPath.MERCHANT_MAIN;
        } else if (role.equals("ROLE_ADMIN")) {
            return "redirect:" + AuthPath.ADMIN_DASHBOARD;
        } else {
            return "redirect:" + AuthPath.HOME;
        }
    }
}