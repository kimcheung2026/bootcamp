package com.project.datingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable()) // 保持禁用以利表單 POST
        .authorizeHttpRequests(requests -> requests
            // 1. 放行註冊相關、登入、以及靜態資源 (CSS, JS, 圖片)
            .requestMatchers("/register", "/user/register", "/login", "/home", "/uploads/**").permitAll()
            .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

            // 2. 角色權限控管
            // 注意：hasRole("USER") 匹配的是 "ROLE_USER" 權限
            .requestMatchers("/blindBoxOpen").hasRole("USER")
            .requestMatchers("/interestClass").hasRole("MERCHANT")
            .requestMatchers("/members").hasRole("ADMIN")

            // 3. 其他所有路徑都需要登入
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/home", true) // 加上 true 強制登入後跳轉到首頁
            .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .permitAll())
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // 注意：目前的 userDetailsService 是寫死在記憶體中，僅供測試
  // 之後你應該實作 UserDetailsService 從資料庫讀取你註冊的用戶
}