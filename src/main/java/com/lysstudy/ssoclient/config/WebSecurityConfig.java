package com.lysstudy.ssoclient.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/oauth/**").permitAll()
		.antMatchers("static/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and()
		.csrf().disable();
	}
}
