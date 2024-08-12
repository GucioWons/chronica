package com.chronica.server;

import jakarta.ws.rs.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("discUser")
                .password("{noop}discPassword")
                .roles("SYSTEM");
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.NEVER))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.GET, "/eureka/**")
                                .hasRole("SYSTEM")
                                .requestMatchers(HttpMethod.POST, "/eureka/**")
                                .hasRole("SYSTEM")
                                .requestMatchers(HttpMethod.PUT, "/eureka/**")
                                .hasRole("SYSTEM")
                                .requestMatchers(HttpMethod.DELETE, "/eureka/**")
                                .hasRole("SYSTEM")
                                .anyRequest()
                                .authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
