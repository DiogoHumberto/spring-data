package com.springdata.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.domain.CargoModel;

public interface CargoRepository  extends JpaRepository <CargoModel, UUID>{
	
	boolean existsByNome(String nome);
	
}
