package com.project.datingapp.service;

import java.util.List;

import com.project.datingapp.entity.User;
import com.project.datingapp.entity.UserPreference;
import com.project.datingapp.repository.UserPreferenceRepository;
import com.project.datingapp.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchingService {

  private final UserRepository userRepo;
  private final UserPreferenceRepository prefRepo;
  private final PreferenceMatchCalculator calculator;

  // 只找 20 人，效能保證
  private static final int MAX_CANDIDATE = 20;

  // ==========================
  // 核心配對方法
  // ==========================
  @Transactional
  public String matchUser(Long userId) {
    // ==========================================
    // 修復：先檢查 userId != null，消除 @NonNull 警告
    // ==========================================
    if (userId == null) {
      return "INVALID_USER_ID";
    }

    User me = userRepo.findById(userId).orElse(null);
    if (me == null) {
      return "USER_NOT_FOUND";
    }

    UserPreference pref = prefRepo.findByUserId(userId).orElse(null);
    if (pref == null) {
      return "PREFERENCE_NOT_SET";
    }

    // 1. 自身硬條件檢查
    if (!isHardFilterPassed(me)) {
      return "HARD_FILTER_FAILED";
    }

    // 2. 檢查你的配對條件是否合法
    if (!isPreferenceValid(pref)) {
      return "INVALID_PREFERENCE";
    }

    // 3. 檢查配對條件數量（一般3條 / VIP6條）
    if (!calculator.isValidRequirementCount(me, pref)) {
      return "OVER_MAX_CONDITION_LIMIT";
    }

    // 查詢候選人（分頁+限制數量 = 超級快）
    // ==========================
    Page<User> candidatePage = userRepo.findEligibleCandidates(
        me.getId(),
        PageRequest.of(0, MAX_CANDIDATE));
    List<User> candidates = candidatePage.getContent();

    User bestMatch = null;
    double highestScore = 0.0;

    // ==========================
    // 迴圈 + 效能優化 + BREAK
    // ==========================
    for (User candidate : candidates) {

      // 對方硬條件不合格 → 跳過
      if (!isHardFilterPassed(candidate)) {
        continue;
      }

      // 對方不符合你的硬性擇偶要求 → 跳過
      if (!matchesMyHardPreferences(candidate, pref)) {
        continue;
      }

      // 計算匹配度 %
      double score = calculator.calculateMatchPercentage(candidate, pref);

      // 低於 70% → 不要
      if (score < 70.0) {
        continue;
      }

      // 紀錄最高分
      if (score > highestScore) {
        highestScore = score;
        bestMatch = candidate;
      }

      // ======================================
      // 【關鍵】找到 90% 以上 → 直接 BREAK 停止
      // ======================================
      if (highestScore >= 90.0) {
        break;
      }
    }

    if (bestMatch == null) {
      return "NO_MATCH_ABOVE_70%";
    }

    // 配對成功（你可在這裡寫入配對紀錄、建立隊伍等）
    return "MATCH_SUCCESS | SCORE: " + highestScore;
  }

  // ==========================
  // 全域硬條件
  // ==========================
  private boolean isHardFilterPassed(User user) {
    return user.getAge() >= 18
        && "SINGLE".equals(user.getMaritalStatus())
        && user.isMatchingEnabled();
  }

  // ==========================
  // 你的擇偶「硬性條件」驗證
  // ==========================
  private boolean isPreferenceValid(UserPreference pref) {
    Integer minAge = pref.getPreferredAgeMin();
    Integer maxAge = pref.getPreferredAgeMax();
    String genderPref = pref.getPreferredGender();

    if (minAge == null || maxAge == null || genderPref == null)
      return false;
    if (minAge < 18)
      return false;
    if (minAge > maxAge)
      return false;

    return true;
  }

  // ==========================
  // 對方必須符合你的硬性要求
  // ==========================
  private boolean matchesMyHardPreferences(User candidate, UserPreference myPref) {
    // 年齡
    int age = candidate.getAge();
    if (age < myPref.getPreferredAgeMin() || age > myPref.getPreferredAgeMax()) {
      return false;
    }

    // 性別
    String genderPref = myPref.getPreferredGender();
    if (!"ANY".equals(genderPref) && !genderPref.equals(candidate.getGender())) {
      return false;
    }

    // 城市
    if (myPref.getPreferredCity() != null
        && !myPref.getPreferredCity().equals(candidate.getCity())) {
      return false;
    }

    return true;
  }
}