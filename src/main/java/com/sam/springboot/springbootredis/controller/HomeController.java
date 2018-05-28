package com.sam.springboot.springbootredis.controller;

import java.util.Random;

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
		double var = 0.0001f;
		Random random = new Random();
		logger.info("loaded index called");
		for (int i = 0; i < 900000; i++) {
			var = Math.sqrt(random.nextFloat());
			var = Math.sqrt(random.nextFloat());
			var = Math.sqrt(random.nextFloat());
			var = Math.sqrt(random.nextFloat());
			var = Math.sqrt(random.nextFloat());
			var = Math.sqrt(random.nextFloat());
		}

		logger.info("loaded index called {}", var);
		String loginUserName = (String) session.getAttribute("user");
		if (null != loginUserName) {
			model.addAttribute("uname", loginUserName);
			return "userinfo";
		} else {
			return "index";
		}

	}

	@RequestMapping("/login")
	public String login(Model model, @RequestParam("uname") String uname, @RequestParam("password") String password,
			HttpSession session) {
		logger.info("login called");
		session.setAttribute("user", uname);
		model.addAttribute("uname", uname);

		return "userinfo";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("logout called");
		session.invalidate();
		return "redirect:/";
	}
}
