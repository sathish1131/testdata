package com.project.testdata.controller;

import com.project.testdata.repository.TestDataRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class HomeController{

	@Autowired
	private TestDataRepository repo;

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("dataList", repo.findAll());
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

}