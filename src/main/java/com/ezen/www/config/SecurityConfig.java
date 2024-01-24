package com.ezen.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ezen.www.security.CustomAuthMemberService;
import com.ezen.www.security.LoginFailureHandler;
import com.ezen.www.security.LoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder bcPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler authSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	@Bean
	public LoginFailureHandler authFailureHandler() {
		return new LoginFailureHandler();
	}
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomAuthMemberService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserService()).passwordEncoder(bcPasswordEncoder());
	}
	
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/member/list")
		.hasRole("ADMIN")
		.antMatchers("/","/board/list","/board/detail","/comment/**","/upload/**","/resources/**","/member/register","/member/login")
		.permitAll().anyRequest().authenticated();
		
		http.formLogin()
		.usernameParameter("email")
		.passwordParameter("pwd").loginPage("/member/login")
		.successHandler(authSuccessHandler())
		.failureHandler(authFailureHandler());
		
		http.logout()
		.logoutUrl("/member/logout")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
