package com.project.datingapp.service;

import com.project.datingapp.entity.Merchant;
import com.project.datingapp.exception.ErrorCode;
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
    // 1. 驗證 BRN 格式
    validateBrNumber(merchant.getBrNumber());

    // 2. 檢查數據庫唯一性 (使用 ErrorCode ENUM)
    if (merchantRepository.existsByUsername(merchant.getUsername())) {
      throw new MerchantException(ErrorCode.MERCHANT_ALREADY_EXISTS,
          "註冊失敗：帳號 [" + merchant.getUsername() + "] 已被使用");
    }
    if (merchantRepository.existsByBrNumber(merchant.getBrNumber())) {
      throw new MerchantException(ErrorCode.BRN_ALREADY_EXISTS);
    }
    if (merchantRepository.existsByEmail(merchant.getEmail())) {
      throw new MerchantException(ErrorCode.EMAIL_ALREADY_EXISTS);
    }

    // 3. 初始化設定
    merchant.setVerified(false);
    return merchantRepository.save(merchant);
  }

  /**
   * 商家登入
   */
  public Merchant login(String username, String password) {
    // 找不到商家給予 404
    Merchant merchant = merchantRepository.findByUsername(username)
        .orElseThrow(() -> new MerchantException(ErrorCode.MERCHANT_NOT_FOUND));

    // 密碼或帳號錯誤 (基於安全，建議統一用 401 錯誤碼)
    if (!merchant.getPassword().equals(password)) {
      throw new MerchantException(ErrorCode.AUTH_FAILED); // 假設你在 ErrorCode 定義了 AUTH_FAILED
    }

    // 檢查審核狀態 (403)
    if (!merchant.isVerified()) {
      throw new MerchantException(ErrorCode.MERCHANT_NOT_VERIFIED);
    }

    return merchant;
  }

  /**
   * 香港商業登記證 (BRN) 驗證邏輯
   */
  private void validateBrNumber(String brNumber) {
    if (brNumber == null || brNumber.trim().isEmpty()) {
      throw new MerchantException(ErrorCode.BRN_FORMAT_ERROR, "驗證失敗：必須提供 BRN");
    }

    String cleanBrn = brNumber.replaceAll("[\\s-]", "");

    if (cleanBrn.length() < 8 || !cleanBrn.substring(0, 8).matches("\\d{8}")) {
      throw new MerchantException(ErrorCode.BRN_FORMAT_ERROR);
    }
  }
}