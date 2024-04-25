package com.chronica.user.logic.security;

import com.chronica.user.data.constant.Api;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final RequestAuthenticator requestAuthenticator;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.addFilterBefore(requestAuthenticator, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrfConfigurer -> csrfConfigurer
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern(Api.ACCOUNT))
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern(Api.LINK))
                );

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers(mvcMatcherBuilder.pattern(Api.ACCOUNT)).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern(Api.LINK)).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern(Api.SWAGGER_UI)).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern(Api.V_3)).permitAll()
                        .anyRequest()
                        .hasAuthority("USER")
                )
                .logout((logout) -> logout
                        .logoutUrl("/api/account/logout")
                        .clearAuthentication(true)
                        .permitAll());

        return http.getOrBuild();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**");
    }

}
