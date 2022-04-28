package com.psc1.board.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class boardController {
	  @GetMapping("/boardwrite")
//	  @ResponseBody

	
//	return 글자를 그대로 띄울수 있는 바디
		public String boardWriteForm() {
//		  model.addAttribute("greeting", "Hello 타임리프. ^^");
		  
		return "boardwrite";
		
	}

}
