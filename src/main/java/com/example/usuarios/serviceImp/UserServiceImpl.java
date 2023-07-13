package com.example.usuarios.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuarios.entity.User;
import com.example.usuarios.repository.UserRepository;
import com.example.usuarios.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(String birth_date) {
		userRepository.deleteById(birth_date);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(String birth_date) {
		return userRepository.findById(birth_date);
	}

}
