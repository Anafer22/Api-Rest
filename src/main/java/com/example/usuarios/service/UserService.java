package com.example.usuarios.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.usuarios.entity.User;

public interface UserService {
	public User save(User user);
	public Iterable<User> findAll();
	public void deleteById(String birth_date);
	public Page<User> findAll(Pageable pageable);
	public Optional<User> findById(String birth_date);
}
