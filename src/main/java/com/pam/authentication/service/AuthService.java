package com.pam.authentication.service;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pam.authentication.model.AuthRequest;
import com.pam.authentication.util.AuthRequestBuilder;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthService {
	@Value("${application.logon.url}")
	private String access_token_url;
	@Value("${application.logout.url}")
	private String logOff_url;
	@Value("${auth.username}")
	private String username;
	@Value("${auth.pass}")
	private String password;
	public ResponseEntity<String> getAccessToken() throws IOException
	{

		AuthRequestBuilder auth=new AuthRequestBuilder();		
		AuthRequest alRequest = auth.buildAuthRequest(username, password);
 		
 		ObjectMapper mapper = new ObjectMapper();
 		String jsonStr = mapper.writeValueAsString(alRequest);
 		
 		
		RestTemplate restTemplate = new RestTemplate();
	
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
	    // build the request
	    HttpEntity<String> request = new HttpEntity<String>(jsonStr,headers);
		
	 //	  System.out.println("Inside getAccessToken"+request.getBody()+request.
	 //   getHeaders().getValuesAsList("Authorization")); // send POST request
		  
		ResponseEntity<String> response= restTemplate.postForEntity(access_token_url, request,String.class);
		System.out.println("New Authentication Response ");
		//System.out.println(response.getBody()); 
		String authorizationToken=response.getBody().toString();
		
		
	    HttpHeaders headers1 = new HttpHeaders();
	    authorizationToken=authorizationToken.substring(1, authorizationToken.length()-1);
	    System.out.println("Token : "+authorizationToken); 

	    headers1.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers1.setContentType(MediaType.APPLICATION_JSON);
	    headers1.add("User-Agent", "Spring's RestTemplate" ); 
        headers1.add("Authorization", authorizationToken);
	    
		HttpEntity<String> requestEntity = new HttpEntity<String>(null,headers1);
	
		ResponseEntity<String> response1 = restTemplate.exchange(logOff_url, HttpMethod.POST, requestEntity, String.class);
		System.out.println("Log Off Response Code : " +response1.getStatusCodeValue());
		System.out.println("Log off Response : "+response1.getBody());
		return response1;

	}
	
}
