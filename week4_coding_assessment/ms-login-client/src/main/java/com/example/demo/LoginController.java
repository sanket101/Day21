package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/login")
	public String invoke() {
		return "login";
	}
	
	@PostMapping("/addUser")
	public void add(String username, String password) {
		String url = "http://Authentication-Service:8097";
		
		Map<String, String> vars = new HashMap<String, String>();
        vars.put("username", username);
        
        User u = new User(username, password);
        
        restTemplate.postForObject(url, u, String.class, vars);
        
	}
}
