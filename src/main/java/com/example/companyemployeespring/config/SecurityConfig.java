package com.example.companyemployeespring.config;

import com.example.companyemployeespring.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private SecurityService securityService;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(securityService)
        .passwordEncoder(passwordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/company/**")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/employees/**")
                .hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.GET, "/")
                .permitAll()
                .and()
                .csrf()
                .disable()
                .logout()
                .and()
                .formLogin();
    }



}
