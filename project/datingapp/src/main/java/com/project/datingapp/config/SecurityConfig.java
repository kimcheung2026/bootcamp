package com.project.datingapp.config;

import com.project.datingapp.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Autowired
  private CustomLoginSuccessHandler successHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(requests -> requests
            .requestMatchers(AuthPath.STATIC_RESOURCES).permitAll()
            .requestMatchers(AuthPath.PUBLIC).permitAll()
            .requestMatchers(AuthPath.FORGOT_PASSWORD).permitAll()
            .requestMatchers(AuthPath.HOME).permitAll()
            .requestMatchers(AuthPath.ROLE_SWITCH).authenticated()  // Role switch page
            .requestMatchers(AuthPath.ROLE_CURRENT).authenticated() // Get current role API
            .requestMatchers(AuthPath.ROLE_DASHBOARD).authenticated() // Dashboard redirect
            .requestMatchers(AuthPath.USER_ONLY).hasRole("USER")
            .requestMatchers(AuthPath.COURSE_PREFIX + "/**").hasRole("MERCHANT")
            .requestMatchers(AuthPath.ADMIN_ANY).hasRole("ADMIN")
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage(AuthPath.LOGIN)
            .loginProcessingUrl("/login")
            .successHandler(successHandler)
            .failureUrl("/login?error")
            .permitAll())
        .logout(logout -> logout
            .logoutSuccessUrl(AuthPath.LOGIN + "?logout")
            .permitAll())

        // ======================
        // 🔥 保留你要的「自動失效」，但不會報錯！
        // ======================
        .sessionManagement(session -> session
            .invalidSessionUrl(AuthPath.LOGIN) // 失效 → 跳登入
            .sessionFixation().none() // 安全但不斷線
        )

        .userDetailsService(userDetailsService)
        .build();
  }

}