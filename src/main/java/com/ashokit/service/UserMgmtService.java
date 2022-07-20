package com.ashokit.service;

import java.util.Map;

import com.ashokit.bindings.LoginForm;
import com.ashokit.bindings.UnlockAccForm;
import com.ashokit.bindings.UserRegForm;

public interface UserMgmtService {

	//Login Screen related methods
	public String loginCheck(LoginForm loginForm);
	
	//Registration Screen related methods
	public String emailCheck(String emailId);
	
	public Map<Integer, String> loadCountries();
	
	public Map<Integer, String> loadStates(Integer countryId);
	
	public Map<Integer, String> loadCities(Integer stateId);
	
	public String saveUser(UserRegForm userRegForm);
	
	//unlock account screen related methods
	public String unlockAccForm(UnlockAccForm unlockAccForm);
	
	//forgot pwd screen related methods
	public String forgotPwd(String emailId);
}
