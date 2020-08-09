package com.start.coffeeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.start.coffeeshop.controller.entities.Menu;
import com.start.database.ContactRepository;
import com.start.database.MenuRepository;
import com.start.database.UserService;
import com.start.database.UserServiceImpl;
import com.start.exceptions.InvalidInputException;
import com.start.loginAndRegistration.UserRegistrationDto;
import com.start.coffeeshop.controller.entities.Contact;



@RestController

public class CafeController {
   
	@Autowired(required=true)
	private MenuRepository menuRepository;
	
	@Autowired(required=true)
	private ContactRepository contactRepository;
	
	@Autowired(required=true)
    private UserServiceImpl userService;
	
	
	
//	public CafeController(UserServiceImpl userService)
//	{
//		this.userService=userService;
//	}
	
	@RequestMapping(value="/index")
	   public ModelAndView home() {
		   
		  System.out.println("home///");
		   ModelAndView model = new ModelAndView("index");
		   
		 
		   return model;	   
	   }

	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public ModelAndView menu()
	{
	
		System.out.println("home///");
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
		
		System.out.println("home///");
		
		
		return model;	
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public ModelAndView contuct_us(){
		ModelAndView model = new ModelAndView("contact.html");
		model.addObject("contact", new Contact());
		return model;
	}
	
	
	@RequestMapping(value="/contact.html", method=RequestMethod.POST)
	   public ModelAndView contact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result ) {
		  
		ModelAndView model=new ModelAndView("contact.html");
		model.addObject("contact.html", new Contact());
			if(result.hasErrors())
			{		
			return model;
			}
			
	    contactRepository.save(contact);
			
			
		return model;
	   
	   
	}
	   
	   @RequestMapping(value="/registration", method=RequestMethod.GET)
	//  @GetMapping
	   public ModelAndView showRegistrationForm() {
		   System.out.println("valid///");
		   ModelAndView model = new ModelAndView("registration.html");
		   System.out.println("ho///");
		   model.addObject("user", new UserRegistrationDto());
		   System.out.println("ho///");
		   return model;
	   }
	   
	   @RequestMapping(value="/registration.html", method=RequestMethod.POST)
	//  @PostMapping
	   public ModelAndView registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {		   System.out.println("validwith get///");
	   System.out.println("ho///");  
	   ModelAndView model = new ModelAndView("registration.html");
		   model.addObject("user", new UserRegistrationDto());
		   userService.save(userRegistrationDto);
		   
		   return model;
	   }
	   
//	   
	   
	   @RequestMapping(value="/login", method=RequestMethod.GET)
	  public ModelAndView userLogin(){
		   ModelAndView model = new ModelAndView("login");
		   return model;
	   }
	
	public void verifyExistence(List<Menu> menu) {
		for(Menu i : menu) {
			if(i.getDescription()=="NULL")
				i.setDescription(null);
			if(i.getType()=="NULL")
				i.setType(null);
			
			//String price=i.getPrice()+"$";
		}
		
	
	}

}
