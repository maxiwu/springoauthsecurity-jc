package com.umedia.Dragonfly.controller;

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
	
}
