package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.LoginForm;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class LoginRestController {

	@Autowired
	private UserMgmtServiceImpl userMgmtService;

	@PostMapping("/login")
	public String login(LoginForm loginForm) {
		return userMgmtService.loginCheck(loginForm);
	}
}
