package com.project.datingapp.service;

import com.project.datingapp.entity.User;
import com.project.datingapp.entity.UserPreference;

import org.springframework.stereotype.Component;

@Component
public class PreferenceMatchCalculator {

    // 計算匹配度 0~100%
    public double calculateMatchPercentage(User target, UserPreference pref) {
        int total = calculatorTotalConditions(pref);
        if (total == 0)
            return 100.0;

        int match = 0;

        // 標籤匹配
        if (pref.getPreferredTags() != null && target.getTags() != null) {
            for (String tag : pref.getPreferredTags()) {
                if (target.getTags().contains(tag)) {
                    match++;
                }
            }
        }

        // MBTI
        if (pref.getPreferredMbti() != null
                && pref.getPreferredMbti().equals(target.getMbti())) {
            match++;
        }

        return (double) match / total * 100;
    }

    // 計算你設定了幾個條件
    public int calculatorTotalConditions(UserPreference pref) {
        int count = 0;
        if (pref.getPreferredTags() != null)
            count += pref.getPreferredTags().size();
        if (pref.getPreferredMbti() != null)
            count++;
        return count;
    }

    // 一般3條 / VIP6條
    public boolean isValidRequirementCount(User user, UserPreference pref) {
        int max = user.isVip() ? 6 : 3;
        return calculatorTotalConditions(pref) <= max;
    }
}