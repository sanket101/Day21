package com.example.demo;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO obj;
	
	
	@PostMapping(value="/", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public String add(@RequestBody User user) {
		List<User> l =  (List<User>)obj.findAll();
		//System.out.println(l);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getUsername());
			System.out.println(l.get(i).getPassword());
			if(l.get(i).getUsername().equals(user.getUsername())) {
				return "success";
			}
		}
		
		return "fail";
	}
}
