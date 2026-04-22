package com.project.datingapp.repository;

import java.util.Optional; // 1. 記得引入 Optional

import com.project.datingapp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 2. 將回傳型態改為 Optional<User>
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}