package com.project.datingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.datingapp.dto.MerchantRegisterDTO;
import com.project.datingapp.entity.Merchant;
import com.project.datingapp.exception.ErrorCode;
import com.project.datingapp.exception.MerchantException;
import com.project.datingapp.repository.MerchantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantService {

  @Autowired
  private MerchantRepository merchantRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void register(MerchantRegisterDTO dto) {
    // 1. 檢查帳號是否重複
    if (merchantRepository.existsByUsername(dto.getUsername())) {
      throw new MerchantException("商家帳號已存在");
    }

    // 2. 轉換 DTO 為 Entity (封裝原本在 Controller 的邏輯)
    Merchant merchant = new Merchant();
    merchant.setUsername(dto.getUsername());
    merchant.setPassword(passwordEncoder.encode(dto.getPassword())); // 加密
    merchant.setMerchantName(dto.getMerchantName());
    merchant.setBrNumber(dto.getBrNumber());
    merchant.setOwnerName(dto.getOwnerName());
    merchant.setEmail(dto.getEmail());
    merchant.setPhone(dto.getPhone());
    merchant.setAddress(dto.getAddress());
    merchant.setBusiness(dto.getBusiness());
    merchant.setVerified(false); // 預設未審核

    merchantRepository.save(merchant);
  }

  /**
   * 商家註冊
   */
  // ===================== 註冊（完整驗證版） =====================
  @Transactional
  public Merchant register(Merchant merchant) {
    validateBrNumber(merchant.getBrNumber());

    if (merchantRepository.existsByUsername(merchant.getUsername())) {
      throw new MerchantException(ErrorCode.MERCHANT_ALREADY_EXISTS, "註冊失敗：帳號已被使用");
    }
    if (merchantRepository.existsByBrNumber(merchant.getBrNumber())) {
      throw new MerchantException(ErrorCode.BRN_ALREADY_EXISTS);
    }
    if (merchantRepository.existsByEmail(merchant.getEmail())) {
      throw new MerchantException(ErrorCode.EMAIL_ALREADY_EXISTS);
    }

    // 密碼加密
    merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
    merchant.setVerified(false);

    return merchantRepository.save(merchant);
  }

  // ===================== 審核商家 =====================
  @Transactional
  public void verifyMerchant(Long id) {
    Merchant merchant = merchantRepository.findById(id)
        .orElseThrow(() -> new MerchantException(ErrorCode.MERCHANT_NOT_FOUND));

    merchant.setVerified(true);
    merchantRepository.save(merchant);
  }

  // ===================== 取得未審核商家 =====================
  public List<Merchant> getUnverifiedMerchants() {
    return merchantRepository.findAll().stream()
        .filter(m -> !m.isVerified())
        .collect(Collectors.toList());
  }

  // ===================== 登入（重要：這裡我幫你修好了！） =====================
  public Merchant login(String username, String rawPassword) {
    Merchant merchant = merchantRepository.findByUsername(username)
        .orElseThrow(() -> new MerchantException(ErrorCode.MERCHANT_NOT_FOUND));

    // 【關鍵修復】密碼比對要用 passwordEncoder.matches
    if (!passwordEncoder.matches(rawPassword, merchant.getPassword())) {
      throw new MerchantException(ErrorCode.AUTH_FAILED);
    }

    if (!merchant.isVerified()) {
      throw new MerchantException(ErrorCode.MERCHANT_NOT_VERIFIED);
    }

    return merchant;
  }

  // ===================== BRN 驗證 =====================
  private void validateBrNumber(String brNumber) {
    if (brNumber == null || brNumber.trim().isEmpty()) {
      throw new MerchantException(ErrorCode.BRN_FORMAT_ERROR, "必須提供商業登記證");
    }

    String cleanBrn = brNumber.replaceAll("[\\s-]", "");
    if (cleanBrn.length() < 8 || !cleanBrn.substring(0, 8).matches("\\d{8}")) {
      throw new MerchantException(ErrorCode.BRN_FORMAT_ERROR);
    }
  }
}