package com.chronica.user.logic.security;

import com.chronica.user.data.constant.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final RequestAuthenticator requestAuthenticator;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(requestAuthenticator, UsernamePasswordAuthenticationFilter.class)
                .csrf(CsrfConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/api/accounts/sign-in","/api/accounts/sign-up").permitAll()
                        .requestMatchers(HttpMethod.GET,Api.LINKS,Api.SWAGGER_UI,Api.V_3).permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .logout((logout) -> logout
                        .logoutUrl("/api/account/logout")
                        .clearAuthentication(true)
                        .permitAll());

        return http.getOrBuild();
    }

    @Bean
    protected BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**")
                .requestMatchers("/swagger-ui/**")
                .requestMatchers("/v3/**");
    }

}
