package com.project.datingapp.dto;

import lombok.Data;

@Data
public class RoleSwitchDTO {
    private String targetRole; // "USER" or "MERCHANT"
    private String username;
    private String password; // For verification when switching
}