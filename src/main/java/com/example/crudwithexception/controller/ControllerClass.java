package com.example.crudwithexception.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudwithexception.entity.User;
import com.example.crudwithexception.service.UserService;

@RestController
public class ControllerClass {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public ResponseEntity<String> addEmployee(@RequestBody User user){
		userservice.addemploy(user);
		return ResponseEntity.ok("Posted Successfully");
	}

	@GetMapping("/user")
	public List<User> getvalue(){
		return userservice.getallemployee();
				
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getEmp(@PathVariable int id){
		return userservice.Getid(id);	
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<String> editEmp(@RequestBody User user, @PathVariable int id) {
	userservice.empdata(user, id);
	return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated");
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		 userservice.deleteid(id);
		 return ResponseEntity.status(HttpStatus.GONE).body("Deleted Successfully");
		 
	}
	
}

