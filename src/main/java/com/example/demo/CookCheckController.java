package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookCheckController {
	@GetMapping("/checkcook")
	public String CookieCheck() {		

		return "cookieCheck";
	}	
	@GetMapping("/delcook")
	public String CookieDel() {	

		return "cookieDel";
	}
	
	@GetMapping("/getcook")
	public String CookieGet() {
		

		return "cookieGet";
	}	
	
	@GetMapping("/setcook")
	public String CookieSet() {
		

		return "cookieSet";
	}
}

