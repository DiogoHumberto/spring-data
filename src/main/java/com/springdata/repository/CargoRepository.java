package com.springdata.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springdata.domain.CargoModel;

public interface CargoRepository  extends JpaRepository <CargoModel, UUID>{
	
	boolean existsByNome(String nome);
	
	@Query(nativeQuery=true, value="SELECT *  FROM cargo c ORDER BY random() LIMIT :limit")
	List<CargoModel> findRadomCargosLimit(Integer limit);
	
}
