package com.project.datingapp.service;

import com.project.datingapp.entity.Merchant;
import com.project.datingapp.exception.MerchantException;
import com.project.datingapp.repository.MerchantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantService {

  @Autowired
  private MerchantRepository merchantRepository;

  /**
   * 商家註冊
   */
  @Transactional
  public Merchant register(Merchant merchant) {
    // 1. 驗證 BRN 格式 (香港商業登記證)
    validateBrNumber(merchant.getBrNumber());

    // 2. 檢查數據庫唯一性
    if (merchantRepository.existsByUsername(merchant.getUsername())) {
      throw new MerchantException("註冊失敗：帳號 [" + merchant.getUsername() + "] 已被使用");
    }
    if (merchantRepository.existsByBrNumber(merchant.getBrNumber())) {
      throw new MerchantException("註冊失敗：此商業登記證號碼 (BRN) 已被登記");
    }
    if (merchantRepository.existsByEmail(merchant.getEmail())) {
      throw new MerchantException("註冊失敗：此電子郵件已被登記");
    }

    // 3. 初始化設定
    merchant.setVerified(false); // 新註冊商家預設為未審核

    // 注意：這裡應加入密碼加密邏輯，例如使用 BCrypt
    // merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));

    return merchantRepository.save(merchant);
  }

  public void checkStatus(String username) {
    Merchant merchant = merchantRepository.findByUsername(username)
        .orElseThrow(() -> new MerchantException("找不到此商家"));
    if (!merchant.isVerified()) {
      throw new MerchantException("帳號尚未通過審核");
    }
  }

  /**
   * 商家登入
   */
  public Merchant login(String username, String password) {
    Merchant merchant = merchantRepository.findByUsername(username)
        .orElseThrow(() -> new MerchantException("登入失敗：帳號或密碼錯誤"));

    // 檢查密碼 (此處為簡化範例，實務上應比對加密後的密碼)
    if (!merchant.getPassword().equals(password)) {
      throw new MerchantException("登入失敗：帳號或密碼錯誤");
    }

    // 檢查審核狀態
    if (!merchant.isVerified()) {
      throw new MerchantException("登入失敗：您的帳號正在審核中，請稍候");
    }

    return merchant;
  }

  /**
   * 香港商業登記證 (BRN) 驗證邏輯
   */
  private void validateBrNumber(String brNumber) {
    if (brNumber == null || brNumber.trim().isEmpty()) {
      throw new MerchantException("驗證失敗：必須提供商業登記證號碼 (BRN)");
    }

    // 移除空格與連字號進行基本長度檢查
    String cleanBrn = brNumber.replaceAll("[\\s-]", "");

    // 香港 BRN 核心部分為前 8 位數字
    if (cleanBrn.length() < 8) {
      throw new MerchantException("格式錯誤：商業登記證號碼 (BRN) 長度不正確");
    }

    // 可以根據需求加入正則表達式檢查是否為純數字
    if (!cleanBrn.substring(0, 8).matches("\\d{8}")) {
      throw new MerchantException("格式錯誤：BRN 前 8 位必須為數字");
    }
  }
}