package com.project.datingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(requests -> requests
                  .requestMatchers(HttpMethod.GET, "/register").permitAll()
                  .requestMatchers(HttpMethod.GET, "/interestClass").hasAnyAuthority("TEACHER", "ADMIN")
                  .requestMatchers(HttpMethod.GET, "/blindBoxOpen").hasAnyAuthority("STUDENT", "ADMIN")
                  .requestMatchers(HttpMethod.GET, "/members").hasAuthority("ADMIN")
                  .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .build();
        }

      //http
           // 1. 所有请求直接放行
            //.authorizeHttpRequests(auth -> auth
            //    .anyRequest().permitAll()
            //)

            // 2. 关闭CSRF（开发必备，否则接口无法访问）
            //.csrf(csrf -> csrf.disable())

            // 3. 关闭默认登录页面
            //.formLogin(form -> form.disable())

            // 4. 关闭HTTP Basic认证
            //.httpBasic(basic -> basic.disable());

        //return http.build();

    @Bean
    public UserDetailsService userDetailsService() {
      UserDetails user1 = User.withUsername("user1")
                              .password("{noop}111")
                              .authorities("TEACHER")
                              .build();
      UserDetails user2 = User.withUsername("user2")
                              .password("{noop}222")
                              .authorities("STUDENT")
                              .build();
      UserDetails user3 = User.withUsername("user3")
                              .password("{noop}333")
                              .authorities("ADMIN")
                              .build();
      return new InMemoryUserDetailsManager(user1, user2, user3);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}