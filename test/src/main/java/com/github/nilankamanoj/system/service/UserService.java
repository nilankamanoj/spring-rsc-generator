package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.User;
import com.github.nilankamanoj.system.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User findOne(Integer id) {
		User user = userRepository.findOne(id);
		return user;
	}

	public User save(User user) {
		userRepository.save(user);
		User newUser = userRepository.findOne(user.getId());
		return newUser;
	}

}