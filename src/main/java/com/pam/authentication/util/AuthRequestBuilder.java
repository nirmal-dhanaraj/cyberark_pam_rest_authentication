package com.pam.authentication.util;


import com.pam.authentication.model.AuthRequest;

public class AuthRequestBuilder {
	public AuthRequest buildAuthRequest(String username, String password)
	{
		AuthRequest authReq = new AuthRequest();
		authReq.setUsername(username);
		authReq.setPassword(password);
		//authReq.setNewpassword(newPass);
		authReq.setConcurrentSession("false");
		authReq.setSecureMode(false);
		
		return authReq;
		
	}
}
