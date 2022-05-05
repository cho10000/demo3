package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class logoutController {
	@GetMapping("/logout")
	public String logout1(HttpSession session) {
			session.invalidate(); 

			return "cookieGet";
	}		
}
