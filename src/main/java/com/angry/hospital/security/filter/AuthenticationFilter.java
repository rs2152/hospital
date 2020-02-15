package com.angry.hospital.security.filter;

import com.angry.hospital.clinic.service.UserService;
import com.angry.hospital.utils.Constants;
import com.angry.hospital.utils.Utils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AuthenticationFilter extends OncePerRequestFilter {


    private UserService userService;

    public AuthenticationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return  !path.startsWith("/api/v1/") && !path.startsWith("/api/user/uauth/");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpRequest = Utils.asHttp(request);
        HttpServletResponse httpResponse = Utils.asHttp(response);

        Optional<String> token = Optional.ofNullable(httpRequest.getHeader(Constants.AUTHORIZATION_KEY));

        try {

        } catch (Exception e) {
            Utils.sendError(httpResponse, Constants.AUTH_TOKEN_ERROR_MESSAGE);
            return;
        }
        filterChain.doFilter(request, response);
    }


    private Collection<? extends GrantedAuthority> getAuthorities() {

        return new ArrayList<>();
    }
}
