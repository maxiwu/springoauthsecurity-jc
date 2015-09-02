package com.umedia.Dragonfly.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(4)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// default
		/*http.authorizeRequests().antMatchers("/home").authenticated()
				.anyRequest().permitAll().and().formLogin().loginPage("/login")
				.and().httpBasic();*/
		
		http.authorizeRequests().antMatchers("/home").authenticated()
		.and().formLogin();//.loginPage("/login");
		
		//.and().httpBasic();	
		/*http.authorizeRequests().antMatchers("/login").permitAll()
		.and().exceptionHandling().accessDeniedPage("/login?authorization_error=true")
		.and().csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
		.disable().logout().logoutUrl("/logout")
		.logoutSuccessUrl("/login").and().formLogin().loginProcessingUrl("/login")
		.failureUrl("/login?authentication_error=true")
		.loginPage("/login");*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
	
		/*auth.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(passwordEncoder());*/
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	/*@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
	
		return jdbcUserDetailsManager;
	}*/
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
}
