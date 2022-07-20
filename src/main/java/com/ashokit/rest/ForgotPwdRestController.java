package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.UserMgmtServiceImpl;

@RestController
@CrossOrigin
public class ForgotPwdRestController {

	@Autowired
	private UserMgmtServiceImpl userMgmtService;
	
	@GetMapping
	public String forgotPwd(String email) {
		
		return userMgmtService.forgotPwd(email);
	}
}
