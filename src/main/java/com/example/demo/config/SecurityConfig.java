//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests(authorizeRequests ->
//				authorizeRequests
//				//ここに書いてある物以外は直リンク禁止
//					.antMatchers("/", "/resources/**").permitAll()
//					.anyRequest().authenticated()
//					);
//		return http.build();
//	}
//
//}
