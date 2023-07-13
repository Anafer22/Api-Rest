package com.example.usuarios.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;

import jakarta.persistence.*; // Funciona para que pueda importar todas las anotaciones de JPA

@Entity
@Table(name = "user_data")
public class User implements Serializable{
	@Id
	@Column(name = "birth_date")
	private String birth_date;
	private String name;
	private String email;
	
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
