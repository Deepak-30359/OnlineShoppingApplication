package com.shopping.controller;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.shopping.entities.User;
import com.shopping.services.LoginServiceImpl;
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginServiceImpl loginService;
	
	@PostMapping("/{adduser}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		User user1 = loginService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userid}")
				.buildAndExpand(user1.getUserId())
				.toUri();
		return ResponseEntity.created(location).body(user1);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<String> removeUser(@PathVariable User user){
		boolean flag = loginService.removeUser(user);
		if(flag)
			return new ResponseEntity<>("user removed successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("user not removed successfully", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User validateUser(User user) {
		return loginService.validateUser(user);
	}
	
	@PostMapping("/{signout}")
	public User signOut(User user) {
	    return loginService.signOut(user);
	}
	
	

}
