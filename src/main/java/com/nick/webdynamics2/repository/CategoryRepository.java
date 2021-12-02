package com.nick.webdynamics2.repository;

import com.nick.webdynamics2.model.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

@EntityGraph(attributePaths={"name"})
	List<Category>findByName(String name);
	
	Optional<Category> findAllById(long l);

//	Category findByName(String computers);
}
