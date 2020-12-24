package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByid(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User userUpdate = userRepository.getOne(id);
		updateData(userUpdate, user);
		return userRepository.save(userUpdate);
	}

	private void updateData(User userUpdate, User user) {
		userUpdate.setName(user.getName());
		userUpdate.setEmail(user.getEmail());
		userUpdate.setPhone(user.getPhone());
		
	}

}
