package com.chronica.group.configuration;

import lombok.RequiredArgsConstructor;
import org.chronica.library.security.JWTHandler;
import org.chronica.library.security.RequestAuthenticator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(new RequestAuthenticator(new JWTHandler()), UsernamePasswordAuthenticationFilter.class)
                .csrf(CsrfConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/groups/**")
                .hasAnyRole("USER", "ADMINISTRATOR")
                .requestMatchers(HttpMethod.POST, "/api/groups/**")
                .hasAnyRole("USER", "ADMINISTRATOR")
                .requestMatchers(HttpMethod.PUT, "/api/groups/**")
                .hasAnyRole("USER", "ADMINISTRATOR")
                .requestMatchers(HttpMethod.DELETE, "/api/groups/**")
                .hasRole("ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET, "/h2-console/**", "/swagger-ui/**", "/v3/**")
                .hasRole("SYSTEM")
                .anyRequest()
                .authenticated()
        );

        return http.getOrBuild();
    }

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**")
                .requestMatchers("/swagger-ui/**")
                .requestMatchers("/v3/**");
    }
}