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

    // 1. 先查一般使用者 / 管理員 (users 表)
    Optional<User> userOpt = userRepository.findByUsername(username);
    if (userOpt.isPresent()) {
      User user = userOpt.get();

      return org.springframework.security.core.userdetails.User
          .withUsername(user.getUsername())
          .password(user.getPassword())
          .roles(user.getRole().replace("ROLE_", "")) // 關鍵修正
          .build();
    }

    // 2. 再查商家 (app_merchants 表)
    Optional<Merchant> merchantOpt = merchantRepository.findByUsername(username);
    if (merchantOpt.isPresent()) {
      Merchant merchant = merchantOpt.get();

      return org.springframework.security.core.userdetails.User
          .withUsername(merchant.getUsername())
          .password(merchant.getPassword())
          .roles("MERCHANT") // 關鍵修正
          .build();
    }

    // 都找不到
    throw new UsernameNotFoundException("找不到該使用者或商家: " + username);
  }
}