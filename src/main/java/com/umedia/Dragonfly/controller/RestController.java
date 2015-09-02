package com.umedia.Dragonfly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//this is protected by oauth
@Controller
//@RequestMapping("/service")
public class RestController {

	//@RequestMapping(value = "/device", method = RequestMethod.GET)
	//@RequestMapping(value = "/device", params="format=json")
	@RequestMapping(value = "/device/{test}")
	public ResponseEntity<String> register(HttpServletRequest request, @PathVariable String test )
	{
		String deviceid = request.getParameter("deviceid");
		String token = request.getParameter("token");
		//post or get?
		//store device id and its current token
		return new ResponseEntity<String>(HttpStatus.OK) ;
	}
}
