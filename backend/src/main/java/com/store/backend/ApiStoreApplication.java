package com.store.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class ApiStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStoreApplication.class, args);
	}
        
        @EnableWebSecurity
        @Configuration
        public class WebSecurityConfig extends WebSecurityConfigurerAdapter { 
            
            @Override
            protected void configure(HttpSecurity httpSecurity) throws Exception {
                httpSecurity.csrf().disable().addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests()
                        .antMatchers(HttpMethod.OPTIONS).permitAll()
                        .antMatchers(HttpMethod.POST, "/customers", "/customers/login").permitAll()
                        .anyRequest().authenticated();
            
            }
        }

}

