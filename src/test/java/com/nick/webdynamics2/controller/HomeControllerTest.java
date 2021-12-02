package com.nick.webdynamics2.controller;

import com.nick.webdynamics2.model.Category;
import com.nick.webdynamics2.model.Country;
import com.nick.webdynamics2.model.State;
import com.nick.webdynamics2.repository.CategoryRepository;
import com.nick.webdynamics2.repository.CityRepository;
import com.nick.webdynamics2.repository.CountryRepository;
import com.nick.webdynamics2.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HomeControllerTest {
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@Test
	public void createCountry(){
		Country country1 = new Country();
		country1.setName("Italy");
		countryRepo.save(country1);
	}
	
	@Test
	public void createState(){
		Country country = countryRepo.findByName("Germany");
		System.out.println("\nCountry is:\n"+country);
		
		State state = new State();
		state.setName("Freistaat Sachsen");
		state.setCountry(country);
		
		System.out.println("New State is:\n"+state);
		stateRepo.save(state);
		
	}
	
//	////////////////////////////////////
	
	@Test
	public void catTotal(){
		System.out.println(catRepo.findAll());
	}
	
	@Test
	public void findOne(){
		System.out.println(catRepo.findById(14L));
	}
	
	@Test
//	@Transactional
	public void newCat(){
		Category parent = catRepo.findById(23L).get();
		
		Category child=new Category();
		child.setName("6SE");
		child.setParentCat(parent);
		
//
		System.out.println("Parent:\n"+parent);
		System.out.println("\nChild:\n"+child);
		catRepo.save(child);
	}
	
}