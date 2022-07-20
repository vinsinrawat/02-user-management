package com.ashokit.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.bindings.LoginForm;
import com.ashokit.bindings.UnlockAccForm;
import com.ashokit.bindings.UserRegForm;
import com.ashokit.entity.CityMasterEntity;
import com.ashokit.entity.CountryMasterEntity;
import com.ashokit.entity.StateMasterEntity;
import com.ashokit.entity.UserAccountEntity;
import com.ashokit.repository.CityMasterRepo;
import com.ashokit.repository.CountryMasterRepo;
import com.ashokit.repository.StateMasterRepo;
import com.ashokit.repository.UserAccountRepo;
import com.ashokit.util.EmailUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService{

	@Autowired
	private UserAccountRepo userRepo;
	
	@Autowired
	private CountryMasterRepo countryRepo;
	
	@Autowired
	private StateMasterRepo stateRepo;
	
	@Autowired
	private CityMasterRepo cityRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public String loginCheck(LoginForm loginForm) {
		UserAccountEntity userAcc = userRepo.findByEmailAndPazzword(loginForm.getEmail(), loginForm.getPassword());
		if(userAcc == null) {
			return "Invalid Credentials";
		}
		
		if(userAcc.getAccStatus().equals("LOCKED")) {
			return "Your Account Locked";
		}
		
		return "SUCCESS";
	}

	@Override
	public String emailCheck(String emailId) {
		UserAccountEntity userAcc = userRepo.findByEmail(emailId);
	  	
		if(userAcc == null) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}

	@Override
	public Map<Integer, String> loadCountries() {
		List<CountryMasterEntity> countries = countryRepo.findAll();
		
		//convert List of String into Map
		Map<Integer, String> countryMap = new HashMap<>();
		countries.forEach(country ->{
			countryMap.put(country.getCountryId(), country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> loadStates(Integer countryId) {
		List<StateMasterEntity> states= stateRepo.findByCountryId(countryId);
		
		Map<Integer, String> statesMap = new HashMap<>();
		states.forEach(state -> {
			statesMap.put(state.getStateId(), state.getStateName());
		});
		
		return statesMap;
	}

	@Override
	public Map<Integer, String> loadCities(Integer stateId) {
		List<CityMasterEntity> cities = cityRepo.findByStateId(stateId);
		
		Map<Integer, String> citiesmap = new HashMap<>();
		cities.forEach(city -> {
			citiesmap.put(city.getCityId(), city.getCityName());
		});
		return citiesmap;
	}

	@Override
	public String saveUser(UserRegForm userRegForm) {
		
		//need to generate random password
		userRegForm.setPazzword(generateRandomPwd(6)); 
		
		UserAccountEntity entity = new UserAccountEntity();
		//copy data from binding class to entity class so that we can save it into DB
		BeanUtils.copyProperties(userRegForm, entity);
		entity.setAccStatus("LOCKED");
		userRepo.save(entity);
		
		//Send Email with Temp Pwd to unlock acc
		String subject = "User Registration - Ashok IT";
		String emailBody = readUnlockAccEmailBody(userRegForm);
		emailUtils.sendEmail(userRegForm.getEmail(), subject, emailBody);
		
		return "SUCCESS";
	}

	@Override
	public String unlockAccForm(UnlockAccForm unlockAccForm) {
		UserAccountEntity userAcc = userRepo.findByEmailAndPazzword(unlockAccForm.getEmail(), unlockAccForm.getTempPwd());
		
		if(userAcc == null) {
			return "Invalid Temporary Pwd";
		}
		
		userAcc.setPazzword(unlockAccForm.getNewPwd());
		userAcc.setAccStatus("UNLOCKED");
		userRepo.save(userAcc);
		
		return "SUCCESS";
	}

	@Override
	public String forgotPwd(String emailId) {
		UserAccountEntity userAcc = userRepo.findByEmail(emailId);
		
		if(userAcc == null) {
			return "Invalid Email Id";
		}
		
		//Send pwd to user in the email
		String subject = "Recover Password - Ashok IT";
		String body = readRecoverPwdEmailBody(userAcc);
		emailUtils.sendEmail(emailId, subject, body);
		
		return "Password sent to your registered Email";
	}
	
	//Generate Random Password
	private String generateRandomPwd(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }

	
	private String readUnlockAccEmailBody(UserRegForm user) {
		String body = "";
		StringBuffer buffer = new StringBuffer();
		Path filePath = Paths.get("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		
		try(Stream<String> stream = Files.lines(filePath)){
			stream.forEach(line -> {
				buffer.append(line);
			});
			

			body = buffer.toString();
			body = body.replace("{FNAME}", user.getFname());
			body = body.replace("{LNAME}", user.getLname());
			body = body.replace("{TEMP-PWD}", user.getPazzword());
			body = body.replace("{EMAIL}", user.getEmail());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return body;
	}
	
	private String readRecoverPwdEmailBody(UserAccountEntity entity) {
		String body = "";
		StringBuffer buffer = new StringBuffer();
		Path filePath = Paths.get("RECOVER-PASSWORD-EMAIL-BODY-TEMPLATE.txt");
		
		try(Stream<String> stream = Files.lines(filePath)){
			stream.forEach(line -> {
				buffer.append(line);
			});
			

			body = buffer.toString();
			body = body.replace("{FNAME}", entity.getFname());
			body = body.replace("{LNAME}", entity.getLname());
			body = body.replace("{PWD}", entity.getPazzword());
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return body;
	}
}
