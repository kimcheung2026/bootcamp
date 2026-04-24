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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

    String username = authentication.getName();

    log.info("User [{}] login successful, Roles: {}", username, roles);
    if (roles.contains("ROLE_ADMIN")) {
      log.info("Admin account, redirect to admin dashboard");
      response.sendRedirect(AuthPath.ADMIN_DASHBOARD);
    } else if (roles.contains("ROLE_MERCHANT")) {
      log.info("Merchant account, redirect to merchant page");
      response.sendRedirect(AuthPath.MERCHANT_MAIN);
    } else {
      log.info("User, redirect to home page");
      response.sendRedirect(AuthPath.HOME);
    }
  }
}