package com.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

//@Data
public class UserRegForm {

	private String fname;
	private String lname;
	private String email;
	private String pazzword;
	private String accStatus;
	private Long phno;
	private LocalDate dob;
	private String gender;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;

	public UserRegForm() {
	}

	public UserRegForm(String fname, String lname, String email, String pazzword, String accStatus, Long phno,
			LocalDate dob, String gender, Integer cityId, Integer stateId, Integer countryId) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pazzword = pazzword;
		this.accStatus = accStatus;
		this.phno = phno;
		this.dob = dob;
		this.gender = gender;
		this.cityId = cityId;
		this.stateId = stateId;
		this.countryId = countryId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPazzword() {
		return pazzword;
	}

	public void setPazzword(String pazzword) {
		this.pazzword = pazzword;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "UserRegForm [fname=" + fname + ", lname=" + lname + ", email=" + email + ", pazzword=" + pazzword
				+ ", accStatus=" + accStatus + ", phno=" + phno + ", dob=" + dob + ", gender=" + gender + ", cityId="
				+ cityId + ", stateId=" + stateId + ", countryId=" + countryId + "]";
	}

}
