package com.angry.hospital.security;

import com.angry.hospital.utils.Utils;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RestAuthenticationEntryPoint
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final Gson gson;

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) {
        try {
            Utils.httpResponse(response, "Bad Credentials", HttpStatus.UNAUTHORIZED, HttpServletResponse.SC_UNAUTHORIZED);
        } catch (IOException e) {
            log.info("Exception in rest authentication : "+ e.getMessage());
        }
    }
}
