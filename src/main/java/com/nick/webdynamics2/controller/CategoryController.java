package com.nick.webdynamics2.controller;

import com.google.gson.Gson;
import com.nick.webdynamics2.model.Category;
import com.nick.webdynamics2.model.Country;
import com.nick.webdynamics2.repository.CategoryRepository;
import com.nick.webdynamics2.repository.CityRepository;
import com.nick.webdynamics2.repository.CountryRepository;
import com.nick.webdynamics2.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@GetMapping("/cat-1")
//	@Transactional
	public List getCatalog(){
		
		List<Category>total=catRepo.findAll();
		Category sample=total.get(0);
		System.out.println("--------------catt------------------------\n\n"+sample);
//		return  sample;
//		return catRepo.findByName("Phones");
		Gson gson= new Gson();
		return  catRepo.findAll();
	}
	
	@GetMapping("/country")
	@ResponseBody
	public List countries(Model model){
		model.addAttribute("countryes", countryRepo.findAll());
//		Gson gson= new Gson();
//		System.out.println("\n******************************\n"+ gson.toJson(model));
		return countryRepo.findAll();
	}
	
	@GetMapping("/catalog")
//		public List<Category> catalog(){
		public Category catalog(){
		
		Category parent1 =new Category();
		
		parent1.setId(25L);
		parent1.setName("Parent");
		
		Category child1 =new Category();
		child1.setId(26L);
		child1.setName("Child1");
		child1.setParentCat(parent1);
		
		Category child2 =new Category();
		child2.setId(26L);
		child2.setName("Child2");
		child2.setParentCat(parent1);
		
		Set<Category>childrenset1=new HashSet<>();
		childrenset1.add(child1);
		childrenset1.add(child2);
		
		parent1.setChildSet(childrenset1);
		
		
//		parent1.setChildSet(childrenset1);
		
//		Set<Category> children = new TreeSet<>();
//
//		children.add(child);
//		children.add(parent);
		List<Category>catlist1=new ArrayList<>();
		catlist1.add(parent1);
		catlist1.add(child1);
		catlist1.add(child2);
		System.out.println("parent:=================\n"+parent1);
		
		return child1;
		}
}
