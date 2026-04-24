package com.project.datingapp.repository;

import java.util.Optional; // 1. 記得引入 Optional

import com.project.datingapp.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 2. 將回傳型態改為 Optional<User>
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    // ==============================
    // 配對專用：查詢可配對候選清單
    // ==============================
    @Query("SELECT u FROM User u "
            + "WHERE u.id != :userId "
            + "AND u.age >= 18 "
            + "AND u.maritalStatus = 'SINGLE' "
            + "AND u.matchingEnabled = true "
            + "AND u.role = 'ROLE_USER'")
    Page<User> findEligibleCandidates(
            @Param("userId") Long userId,
            Pageable pageable);
}