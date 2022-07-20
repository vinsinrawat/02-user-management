package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
//@Data
public class CountryMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "COUNTRY_CODE")
	private Integer countryCode;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	public CountryMasterEntity() {
	}

	public CountryMasterEntity(Integer countryId, Integer countryCode, String countryName) {
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "CountryMasterEntity [countryId=" + countryId + ", countryCode=" + countryCode + ", countryName="
				+ countryName + "]";
	}

}
