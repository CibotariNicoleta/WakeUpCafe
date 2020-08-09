package com.start.database;

import org.springframework.data.repository.CrudRepository;

import com.start.coffeeshop.controller.entities.Contact;
import com.start.coffeeshop.controller.entities.Menu;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	

}
