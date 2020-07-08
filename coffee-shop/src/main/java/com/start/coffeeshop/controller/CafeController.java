package com.start.coffeeshop.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.start.database.MenuRepository;



@RestController

public class CafeController {
   
	@Autowired(required=true)
	private MenuRepository menuRepository;

	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public ModelAndView menu()
	{
	
		List<Menu> food = new ArrayList<Menu>();
		List<Menu> coffee = new ArrayList<Menu>();
		List<Menu> tacos = new ArrayList<Menu>();
		List<Menu> fresh = new ArrayList<Menu>();
		List<Menu> smoothies = new ArrayList<Menu>();
		List<Menu> kitchen = new ArrayList<Menu>();
		List<Menu> matcha = new ArrayList<Menu>();
		
		food=menuRepository.findByType("FOOD");
		verifyExistence(food);
		coffee=menuRepository.findByType("DEVOCION COFFEE");
		verifyExistence(coffee);
		tacos=menuRepository.findByType("TACOS");
		verifyExistence(tacos);
		fresh=menuRepository.findByType("FRESH STARTS");
		verifyExistence(fresh);
		smoothies=menuRepository.findByType("SMOOTHIES");
		verifyExistence(smoothies);
		kitchen=menuRepository.findByType("SAGE KITCHEN BAKED GOODS");
		verifyExistence(kitchen);
		matcha=menuRepository.findByType("MATCHAFUL MATCHA");
		verifyExistence(matcha);
		
		ModelAndView model = new ModelAndView("menu.html");
		
		model.addObject("food", food);
		model.addObject("coffee", coffee);
		model.addObject("tacos", tacos);
		model.addObject("fresh", fresh);
		model.addObject("smoothies", smoothies);
		model.addObject("kitchen", kitchen);
		model.addObject("matcha", matcha);
		
		
		
		
		return model;	
	}
	
	
	
	public void verifyExistence(List<Menu> menu) {
		for(Menu i : menu) {
			if(i.getDescription()=="NULL")
				i.setDescription(null);
			if(i.getType()=="NULL")
				i.setType(null);
			
			String price=i.getPrice()+"$";
		}
		
	
	}

}
