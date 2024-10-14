package com.no1.jpashopping.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityUserDetailConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/index.html","/", "/system/**").permitAll()
                        .requestMatchers("/board/**").authenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/system/login")
                        .defaultSuccessUrl("/board/getBoardList", true))
                .exceptionHandling(e -> e.accessDeniedPage("/system/accessDenied"))
                .logout(logout -> logout.logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/"));
        return http.build();
    }
}
