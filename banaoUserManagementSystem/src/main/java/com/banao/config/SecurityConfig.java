package com.banao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Configuration
	public class SecurityConfiguration {

		@SuppressWarnings("removal")
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

			http.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/user/**")
					.hasRole("USER").requestMatchers("/**").permitAll().and().formLogin().loginPage("/signIn")
					.loginProcessingUrl("/login").defaultSuccessUrl("/user/").and().csrf().disable();
			return http.build();
		}

	}

}
