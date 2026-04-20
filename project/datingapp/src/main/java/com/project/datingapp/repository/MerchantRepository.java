package com.project.datingapp.repository;

import java.util.Optional;

import com.project.datingapp.entity.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    // 1. 用於登入：根據帳號尋找商家
    Optional<Merchant> findByUsername(String username);

    // 2. 用於註冊檢查：檢查帳號是否已存在
    boolean existsByUsername(String username);

    // 3. 用於註冊檢查：檢查商業登記證 (BRN) 是否已存在
    boolean existsByBrNumber(String brNumber);

    // 4. 用於註冊檢查：檢查郵箱是否已重複
    boolean existsByEmail(String email);

    // 5. 搜尋功能：根據商家名稱進行模糊查詢
    // List<Merchant> findByMerchantNameContaining(String name);
}