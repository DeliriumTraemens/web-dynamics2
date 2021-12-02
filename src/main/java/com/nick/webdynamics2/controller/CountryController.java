package com.nick.webdynamics2.controller;

import com.nick.webdynamics2.model.Country;
import com.nick.webdynamics2.repository.CategoryRepository;
import com.nick.webdynamics2.repository.CityRepository;
import com.nick.webdynamics2.repository.CountryRepository;
import com.nick.webdynamics2.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@GetMapping("/countryes")
	@ResponseBody
	public List counryList(){
		return countryRepo.findAll();
	}
	
	@GetMapping("/country/{id}")
	@ResponseBody
	public Optional getCountrybyId(@PathVariable("id")  Integer id){
		return countryRepo.findById(id);
	}
	
	@GetMapping("/countryList")
	public String getCountryList(){
		return "countryList";
	}
	
}