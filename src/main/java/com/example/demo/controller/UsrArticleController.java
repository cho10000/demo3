package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;

@Controller
public class UsrArticleController {
	private List<Article> articles;
	private int atricleLastId;
	
	
	 public UsrArticleController() {
		 //멤버변수 초기화
		 atricleLastId =0;
		 articles = new ArrayList<>();
		 articles.add(new Article(++atricleLastId, "2020-12-12 12:12:12", "재목1", "제목2"));
		 articles.add(new Article(++atricleLastId, "2020-12-13 12:12:12", "재목11123412341", "제목234123412"));
	 }

	 
	 @RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showDetail(int id) {

	return articles.get(id -1);
	}

	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> showList() {
        
		return articles;
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(String regDate, String title, String body) {        
		 articles.add(new Article(++atricleLastId, regDate, title, body	));
		 Map<String, Object> rs = new HashMap<>();
		 rs.put("resultCode", "S-1");
		 rs.put("msg", "성공하였습니다.");
		 rs.put("id = ",atricleLastId);
		return rs;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public Map<String, Object> doDelete(int id) {      
		boolean deleteArticleRs = deleteArticle(id);
		Map<String, Object> rs = new HashMap<>();
		
		if (deleteArticleRs) {
			 rs.put("resultCode", "S-1");
			 rs.put("msg", "성공하였습니다.");
			 rs.put("id = ",id);
		}
		else
		{
			 rs.put("resultCode", "F-1");
			 rs.put("msg", "실패하였습니다.");
			 rs.put("id = ",id);	
		}
		return rs;
	}


	private boolean deleteArticle(int id) {
		// TODO Auto-generated method stub
		for (Article article : articles) {
			if (article.getId() == id) {
				articles.remove(article);
				return true;
				}			
		}
		return false;
	}


}
