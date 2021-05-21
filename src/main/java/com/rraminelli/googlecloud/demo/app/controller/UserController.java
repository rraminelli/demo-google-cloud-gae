package com.rraminelli.googlecloud.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rraminelli.googlecloud.demo.domain.entity.User;
import com.rraminelli.googlecloud.demo.domain.repository.IUserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private IUserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	
}
