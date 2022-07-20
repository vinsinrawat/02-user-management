package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.StateMasterEntity;

public interface StateMasterRepo extends JpaRepository<StateMasterEntity, Serializable>{

	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
