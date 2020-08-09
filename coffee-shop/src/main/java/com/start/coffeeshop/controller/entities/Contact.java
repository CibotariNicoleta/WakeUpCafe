package com.start.coffeeshop.controller.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity


@Table(name="Contact")

public class Contact {
	
	
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@NotBlank
	@Size(min=3, max=8)
	@Column(name="firstName") 
	private String firstName;
	
	@NotEmpty(message="Please enter your secondName")
	@Column(name="secondName") 
	private String secondName;
	
	@NotEmpty(message="Please enter your email")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="Please enter your subject")
	@Column(name="subject")
	private String subject;
	
	@NotEmpty(message="Please enter your message")
	@Column(name="message")
	private String message;
	
	public Contact(String fname, String sname, String email, String subject, String message)
	{
		this.firstName = fname;
		this.secondName = sname;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	public Contact() {
		
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
