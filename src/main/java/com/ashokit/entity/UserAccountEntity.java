package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USER_ACCOUNT")
//@Data
public class UserAccountEntity {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String fname;

	@Column(name = "LAST_NAME")
	private String lname;

	@Column(name = "USER_EMAIL", unique = true)
	private String email;

	@Column(name = "USER_PWD")
	private String pazzword;

	@Column(name = "ACC_STATUS")
	private String accStatus;

	@Column(name = "USER_PHNO")
	private Long phno;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CITY")
	private Integer cityId;

	@Column(name = "STATE")
	private Integer stateId;

	@Column(name = "COUNTRY")
	private Integer countryId;

	public UserAccountEntity() {
	}

	public UserAccountEntity(Integer userId, String fname, String lname, String email, String pazzword,
			String accStatus, Long phno, LocalDate dob, String gender, Integer cityId, Integer stateId,
			Integer countryId) {
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "UserAccountEntity [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", pazzword=" + pazzword + ", accStatus=" + accStatus + ", phno=" + phno + ", dob=" + dob
				+ ", gender=" + gender + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId=" + countryId
				+ "]";
	}

}
