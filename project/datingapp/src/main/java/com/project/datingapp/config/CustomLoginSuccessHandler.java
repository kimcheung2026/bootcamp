package com.project.datingapp.config;

import java.io.IOException;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

    if (roles.contains("ROLE_ADMIN")) {
      // 管理員 → 首頁
      response.sendRedirect(AuthPath.HOME);
    } else if (roles.contains("ROLE_MERCHANT")) {
      // 商家 → 首頁
      response.sendRedirect(AuthPath.HOME);
    } else {
      // 一般使用者 → 首頁
      response.sendRedirect(AuthPath.HOME);
    }
  }
}