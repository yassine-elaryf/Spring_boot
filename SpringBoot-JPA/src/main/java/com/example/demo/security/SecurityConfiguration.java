package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	   @Autowired
	   private UserDetailsService userDetailsService;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	 
	    	http.authorizeRequests()
			.antMatchers("/", "/*student*/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll().loginPage("/login")
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	    }
		@Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
}
