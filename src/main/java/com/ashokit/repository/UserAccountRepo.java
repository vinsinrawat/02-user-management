package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.UserAccountEntity;

public interface UserAccountRepo extends JpaRepository<UserAccountEntity, Serializable>{

	
	public UserAccountEntity findByEmailAndPazzword(String email, String pazzword);

	public UserAccountEntity findByEmail(String email);
}
