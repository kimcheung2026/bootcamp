package com.project.datingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MerchantRegisterDTO {
  private String username;
  private String password;
  private String merchantName; // 商家/團體名稱
  @NotBlank(message = "統編不能為空")
  @Pattern(regexp = "^[0-9]{8}$", message = "統編格式錯誤，須為 8 位數字")
  private String brNumber; // 商業登記證號碼
  private String ownerName; // 負責人
  private String email;
  private String phone;
  private String address;
  private String business; // 營業項目
}