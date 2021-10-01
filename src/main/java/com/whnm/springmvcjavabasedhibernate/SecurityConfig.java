package com.whnm.springmvcjavabasedhibernate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT * FROM (SELECT nombre AS username, clave AS password, estado AS enabled FROM usuario) as USERS WHERE username = ?")
			.authoritiesByUsernameQuery("SELECT * FROM (SELECT nombre AS username, tipo AS AUTHORITY FROM usuario) as AUTHORITIES WHERE username = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/persona**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.and().formLogin().loginPage("/principal")
			.loginProcessingUrl("/j_spring_security_check")
			.defaultSuccessUrl("/personas")
			.failureUrl("/login?error")
			.usernameParameter("usuario")
			.passwordParameter("clave")
			.and().logout().logoutSuccessUrl("/login?logout")
			.logoutUrl("/j_spring_security_logout")
			.and().exceptionHandling().accessDeniedPage("/403")
			.and().csrf();
	}
}
