package me.bs.java.spring.springboot.usermanagement.frontend.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

	@RequestMapping("/")
	public String test ()
	{
		return "hello test";
		
	}
	
}
