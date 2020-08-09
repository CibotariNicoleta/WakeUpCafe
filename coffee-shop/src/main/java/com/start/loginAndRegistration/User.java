package com.start.loginAndRegistration;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="auth_user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "auth_user_id")
	private int id;
   
   @Column(name="first_name")
	private String name;
   
   @Column(name="last_name")
	private String lastName;
   
   @Column(name="email")
	private String email;
   
   @Column(name="password")
	private String password;
   
   

@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name="auth_user_id"), inverseJoinColumns = @JoinColumn(name="auth_role_id"))
	
   public Collection<Role> roles;


public User() {
	
}

public User(String name, String lastName, String email, String password, Collection<Role> roles) {
	super();
	this.name = name;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.roles = roles;
}

public long getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public Collection<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
   
   
   
	
}
