package com.chronica.user.logic.security;

import com.chronica.user.data.constant.Role;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.chronica.user.logic.basic.AccountBasicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@Component
@RequiredArgsConstructor
@Slf4j
public class RequestAuthenticator extends OncePerRequestFilter {
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestAuthenticator.class);
    private final JWTHandler JWTHandler;
    private final AccountBasicService accountBasicService;
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String mail = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            mail = JWTHandler.extractUsername(token);
            LOGGER.info("Account mail: " + mail);
        }

        if (mail != null && JWTHandler.validateToken(token, mail)) {

            final Role role = accountBasicService.findAccountByMail(mail).getRole();
            LOGGER.info("Account role: " + role);
            Collection<GrantedAuthority> getRoleAuthorities = new ArrayList<>();
            getRoleAuthorities.add((GrantedAuthority) () -> String.valueOf(role));

            Authentication authToken = new UsernamePasswordAuthenticationToken(mail, null, getRoleAuthorities);

            LOGGER.info("Authorities: " + authToken.getAuthorities().size());

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}
