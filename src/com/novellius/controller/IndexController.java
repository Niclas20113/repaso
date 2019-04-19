package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("message", "Message from model");
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(Model model) {
		return "about";
	}
}
