package com.example.usuarios.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.usuarios.entity.User;
import com.example.usuarios.repository.UserRepository;
import com.example.usuarios.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/app")
	public String list(Model model) {
		Iterable<User> users = userService.findAll();
		model.addAttribute("users",users);
		return "/app";
	}
	//Read an user
	@GetMapping("/fnd")
	public String read(User user, Model model) {
		String url = "";
		if(user.getBirth_date() !="" && user.getBirth_date() != null) {
			LinkedList<User> users = new LinkedList<User>();
			
			Optional<User> oUser = userService.findById(user.getBirth_date());
			users.add(((oUser.get() != null) ? oUser.get() : null));
			
			model.addAttribute("users", users);
			url = "/qry";
		}else {
			url = "redirect:/";
		}
		return url;
	}
	//Create a new user
	@GetMapping("/add")
	public String add(User user) {
		return "add";
	}
	
	@PostMapping("/create")
	public String create(User user) {
		userService.save(user);
		return "redirect:/";
		
	}
	//Update an user 
	@GetMapping("/upd/{birth_date}")
	public String upd(User user, Model model) {
		Optional<User> oUser = userService.findById(user.getBirth_date());
		model.addAttribute("user", oUser);
		return "/upd";	
	}
	
	@PostMapping("/save")
	public String save(User user) {
		if(user != null) {
			userService.save(user);
		}
		return "redirect:/";
	}
	//Delete an user
	@GetMapping("/del/{birth_date}")
	public String delete(@PathVariable(value = "birth_date") String userBirth_date) {
		userService.deleteById(userBirth_date);
		return "redirect:/";
	}

}

