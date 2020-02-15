package com.angry.hospital.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Component
@Order
@Slf4j
public class WebFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("API URL : " + req.getRequestURL());
        chain.doFilter(new HttpServletRequestWrapper(req), new HttpServletResponseWrapper((HttpServletResponse) response));
    }

    @Override
    public void destroy() {
        log.info("Destroy WebFilter");
    }

    @Override
    public void init(FilterConfig arg0) {
        log.info("Initiating WebFilter");
    }

}
