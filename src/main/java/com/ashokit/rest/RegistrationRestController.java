package com.ashokit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.UserRegForm;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class RegistrationRestController {

	@Autowired
	private UserMgmtServiceImpl userMgmtService;
	
	@GetMapping("/countries")
	public Map<Integer, String> getCountries(){
		return userMgmtService.loadCountries();
	}
	
	@GetMapping("/states/{countryid}")
	public Map<Integer, String> getStates(@PathVariable("countryid") Integer countryId){
		
		return userMgmtService.loadStates(countryId);
	}
	
	@GetMapping("/cities/{stateid}")
	public Map<Integer, String> getCities(@PathVariable("stateid") Integer stateId){
		return userMgmtService.loadCities(stateId);
	}
	
	@GetMapping("/emailCheck/{email}")
	public String emailCheck(@PathVariable("email") String emailId) {
		
		return userMgmtService.emailCheck(emailId);
	}
	
	@PostMapping("/user")
	public String User(UserRegForm userRegForm) {
		
		return userMgmtService.saveUser(userRegForm);
	}
}
