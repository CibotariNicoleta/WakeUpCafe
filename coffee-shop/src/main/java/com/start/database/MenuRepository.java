package com.start.database;

import java.util.List;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.start.coffeeshop.controller.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	List<Menu> findByType(String type);
	
	
}