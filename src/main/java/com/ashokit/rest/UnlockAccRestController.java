package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.UnlockAccForm;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
@CrossOrigin
public class UnlockAccRestController {

	@Autowired
	private UserMgmtServiceImpl userMgmtService;
	
	@PostMapping("/unlock")
	public String unlockAcc(UnlockAccForm unlockAccForm) {
		
		return userMgmtService.unlockAccForm(unlockAccForm);
	}
}
