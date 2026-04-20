package com.project.datingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.project.datingapp")
@EntityScan(basePackages = "com.project.datingapp")
// 重点：关掉 Spring Security 自动登录
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DatingappApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatingappApplication.class, args);
    }
}
