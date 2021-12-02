package com.nick.webdynamics2.controller;

import com.nick.webdynamics2.model.Category;
import com.nick.webdynamics2.repository.CategoryRepository;
import com.nick.webdynamics2.repository.CityRepository;
import com.nick.webdynamics2.repository.CountryRepository;
import com.nick.webdynamics2.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	CityRepository cityRepo;
	@Autowired
	StateRepository stateRepo;
	@Autowired
	CountryRepository countryRepo;
	
	
//	@GetMapping("/")
	@RequestMapping("/")
	public String homePage(Model model){
		model.addAttribute("greeting","Mycola");
		model.addAttribute("countries", countryRepo.findAll());
//		return "home";
//		return "ajax";
//		return "cascading-main";
		return "jqueryLessons";
	}
	
	@GetMapping("/cat")
	public String categoryMain (Model model){
		model.addAttribute("categoryListTotal", catRepo.findAll());
		return "category-main";
		
	}
	
	
	
	
}
