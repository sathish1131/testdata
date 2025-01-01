package com.project.testdata.controller;

import com.project.testdata.service.TestDataService;
import com.project.testdata.models.TestDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HomeController{

	@Autowired
	private TestDataService dataService;

	@GetMapping("/")
	public String home(){
		return "index";
	}

	@GetMapping("/testdata")
	public String testdata(Model model){
		model.addAttribute("dataList", dataService.getAllTestData());
		return "testdata";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@DeleteMapping("/delete-data/{id}")
	public String deleteData(@PathVariable int id, Model model){
		dataService.deleteTestData(id);
		model.addAttribute("dataList", dataService.getAllTestData());
		return "testdata :: data-table";
	}

	@PostMapping("/add-data")
	public String addData(@RequestBody TestDataModel data, Model model){
		dataService.addTestData(data);
		model.addAttribute("dataList", dataService.getAllTestData());
		return "testdata :: data-table";
	}

	@PostMapping("/update-data/{id}")
	public String updateData(@PathVariable int id, @RequestBody TestDataModel data, Model model){
		dataService.updateTestData(id, data);
		model.addAttribute("dataList", dataService.getAllTestData());
		return "testdata :: data-table";
	}

}