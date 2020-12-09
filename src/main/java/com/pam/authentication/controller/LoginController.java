package com.pam.authentication.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



import com.pam.authentication.service.AuthService;


@Controller
public class LoginController {
	
private final AuthService authService;
	
	@Autowired
	LoginController(final AuthService authService){
		this.authService= authService;

	}
	
	@RequestMapping("/getAccessToken")
	public ResponseEntity<String> getAccessToken() throws Exception {
		return authService.getAccessToken();
	}
	

}