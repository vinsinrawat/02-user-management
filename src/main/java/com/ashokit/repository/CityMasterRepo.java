package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CityMasterEntity;

public interface CityMasterRepo extends JpaRepository<CityMasterEntity, Integer>{

	public List<CityMasterEntity> findByStateId(Integer stateId);
}
