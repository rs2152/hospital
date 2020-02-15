package com.angry.hospital.utils;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;


public class Utils {

    public static void httpResponse(HttpServletResponse response, String message, HttpStatus unauthorized, int scUnauthorized) throws IOException {
        Gson gson = new Gson();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(scUnauthorized);
        response.getOutputStream().print(gson.toJson(new RResponse().getInstance(message)));
    }

    public static int getOtp() {
        Random generator = new Random();
        return generator.nextInt(900000) + 100000;
    }

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }


    public static void sendError(HttpServletResponse httpResponse, String message) throws IOException {
        Utils.httpResponse(httpResponse, message, HttpStatus.UNAUTHORIZED, HttpServletResponse.SC_UNAUTHORIZED);
    }

    public static HttpServletRequest asHttp(ServletRequest request) {
        return (HttpServletRequest) request;
    }

    public static HttpServletResponse asHttp(ServletResponse response) {
        return (HttpServletResponse) response;
    }




}
