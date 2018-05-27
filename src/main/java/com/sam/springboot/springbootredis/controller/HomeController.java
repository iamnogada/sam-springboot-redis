package com.sam.springboot.springbootredis.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @RequestMapping("/")
	public String index(Model model, HttpSession session) {
		String loginUserName = (String)session.getAttribute("user");
		if(null != loginUserName){
			model.addAttribute("uname",loginUserName);
			return "userinfo";
		}else{
			return "index";
		}
		
	}

	@RequestMapping("/login")
	public String login(Model model,
						@RequestParam("uname") String uname, 
						@RequestParam("password") String password,
						HttpSession session){
		session.setAttribute("user", uname);
		model.addAttribute("uname", uname);
		
		return "userinfo";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}
}

