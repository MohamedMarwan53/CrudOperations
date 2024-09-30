package com.example.crudwithexception.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crudwithexception.entity.User;
import com.example.crudwithexception.entity.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
public void addemploy(User user){
	repository.save(user);
	String successmessage="Id is created successfully";
	return;

}
	public List<User> getallemployee(){
		List<User> getall= new ArrayList<>();
		repository.findAll().forEach(getall::add);
		return getall;
		
	}
	public ResponseEntity<User> Getid(int id){
		if(repository.existsById(id)) {
			Optional<User> employeegetid= repository.findById(id);
			return ResponseEntity.ok(employeegetid.get());
		}
		else {
		   throw new IllegalArgumentException();		}
			
	}
	
	public void empdata(User user, int Id) {
		repository.save(user);
	}
	public void deleteid(int id) {
		repository.deleteById(id);
		
		 
	}
	
}

