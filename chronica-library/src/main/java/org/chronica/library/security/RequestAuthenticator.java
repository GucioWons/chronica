package org.chronica.library.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.chronica.library.enumerated.UserRole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RequestAuthenticator extends OncePerRequestFilter {
    private final JWTHandler jwtHandler;
    private final HandlerExceptionResolver resolver;

    public RequestAuthenticator(JWTHandler jwtHandler, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.jwtHandler = jwtHandler;
        this.resolver = resolver;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String mail = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                mail = jwtHandler.extractUsername(token);
            }
            if (mail != null && jwtHandler.validateToken(token, mail)) {
                List<UserRole> userRoles = jwtHandler.extractRoles(token);
                Collection<GrantedAuthority> authorities = convertRolesToAuthorities(userRoles);
                Authentication authToken = new UsernamePasswordAuthenticationToken(mail, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            resolver.resolveException(request, response, null, e);
        }
    }

    private static Collection<GrantedAuthority> convertRolesToAuthorities(List<UserRole> userRoles) {
        return userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.name()))
                .collect(Collectors.toList());
    }
}
