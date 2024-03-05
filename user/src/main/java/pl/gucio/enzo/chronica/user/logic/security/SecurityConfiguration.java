package pl.gucio.enzo.chronica.user.logic.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import pl.gucio.enzo.chronica.user.data.constant.Api;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final FilterBeforeRequest filterBeforeRequest;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.addFilterBefore(filterBeforeRequest, UsernamePasswordAuthenticationFilter.class).csrf(csrfConfigurer ->
                csrfConfigurer.ignoringRequestMatchers(mvcMatcherBuilder.pattern(Api.ACCOUNT))
        );

        http.authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(mvcMatcherBuilder.pattern(Api.ACCOUNT)).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(Api.LINK)).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(Api.SWAGGER_UI)).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern(Api.V_3)).permitAll()
                                .anyRequest().hasAuthority("USER")
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


}
