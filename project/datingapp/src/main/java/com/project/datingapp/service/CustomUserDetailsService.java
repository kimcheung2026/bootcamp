package com.project.datingapp.service;

import java.util.Optional;

import com.project.datingapp.entity.Merchant;
import com.project.datingapp.entity.User;
import com.project.datingapp.repository.MerchantRepository;
import com.project.datingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MerchantRepository merchantRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    // 1. 先從普通用戶資料表找
    Optional<User> userOpt = userRepository.findByUsername(username);
    if (userOpt.isPresent()) {
      User user = userOpt.get();
      return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
          .password(user.getPassword())
          .authorities("ROLE_USER") // 給予用戶權限
          .build();

    }

    // 2. 如果找不到，再從商家資料表找
    Optional<Merchant> merchantOpt = merchantRepository.findByUsername(username);
    if (merchantOpt.isPresent()) {
      Merchant merchant = merchantOpt.get();

      // 商家需要檢查是否已審核
      String role = merchant.isVerified() ? "ROLE_MERCHANT" : "ROLE_GUEST";

      return org.springframework.security.core.userdetails.User.withUsername(merchant.getUsername())
          .password(merchant.getPassword())
          .authorities(role) // 給予商家或遊客權限
          .build();
    }

    // 3. 都找不到則拋出異常
    throw new UsernameNotFoundException("找不到使用者或商家: " + username);
  }
}
