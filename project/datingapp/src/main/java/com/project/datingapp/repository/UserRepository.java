package com.project.datingapp.repository;

import com.project.datingapp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 可选：根据用户名查询（登录用）
    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}