package com.chronica.server.security;

import jakarta.ws.rs.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class AdminSecurityConfig {

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.NEVER))
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/").hasRole("ADMIN")
                .requestMatchers("/info", "/health").authenticated()
                .anyRequest().denyAll()
                .and().csrf(AbstractHttpConfigurer::disable);
    }
}
