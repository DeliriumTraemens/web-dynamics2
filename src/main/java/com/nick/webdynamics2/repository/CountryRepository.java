package com.nick.webdynamics2.repository;

import com.nick.webdynamics2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
	Country findByName(String country);
}
