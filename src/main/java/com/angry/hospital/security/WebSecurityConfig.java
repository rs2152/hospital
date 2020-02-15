package com.angry.hospital.security;

import com.angry.hospital.clinic.service.UserService;
import com.angry.hospital.configuration.CustomConfiguration;
import com.angry.hospital.security.filter.AuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;
    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;
    private final UserService userService;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final CustomConfiguration customConfiguration;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/ad/cus/**").hasRole("ADMIN")
                .antMatchers("/api/v1/pt/**").hasRole("PATIENT")
                .antMatchers("/api/v1/dct/**").hasRole("DOCTOR")
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .cors()
                .and()
                .addFilterBefore(new AuthenticationFilter(userService), BasicAuthenticationFilter.class);
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/v2/api-docs")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**");
    }


}
