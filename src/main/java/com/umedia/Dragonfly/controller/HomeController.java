package com.umedia.Dragonfly.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/home")
	public String home()
	{
		//test configuration, and resource
		return "home";
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException
	{
		request.logout();
		
		//authentication.setAuthenticated(false);
/*		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			SecurityContextHolder.getContext().getAuthentication().
		}*/
		return "index";
	}
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/clientservice")
	public String createclient() throws Exception
	{
		//create client detail to database
		JdbcClientDetailsServiceBuilder client = new JdbcClientDetailsServiceBuilder();
		client.dataSource(dataSource)
		.withClient("my-trusted-client-with-secret")
         .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
         .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
         .scopes("read", "write", "trust")
         .secret("somesecret");
		
		//maybe called by bootstrap process in java.config, not sure
		client.build();
		
		return "index";
	}
	
}
