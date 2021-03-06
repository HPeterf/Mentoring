package com.epam.firstaid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .inMemoryAuthentication()
         .withUser("admin")
         .password("{noop}admin")
         .roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
        .authorizeRequests()
        .antMatchers("/register").hasAnyRole("ADMIN")
                .and().formLogin().defaultSuccessUrl("/register")
                .and()
                .logout()
                .logoutSuccessUrl("/index?logout")
                .permitAll()
                .and()
                .formLogin().loginPage("/login")
				.permitAll();
    }

}
