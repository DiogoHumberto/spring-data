package com.springdata.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springdata.domain.CargoModel;
import com.springdata.projections.CargoSalarioProjection;

import jakarta.transaction.Transactional;

public interface CargoRepository  extends JpaRepository <CargoModel, UUID>{
	
	final static String NAME_PROC_INSERT = "add_cargo";
	
	boolean existsByNome(String nome);
	
	@Query(nativeQuery=true, value="SELECT *  FROM cargo c ORDER BY random() LIMIT :limit")
	List<CargoModel> findRadomCargosLimit(Integer limit);
	
	@Modifying
	@Transactional
	@Query(value = "call " + NAME_PROC_INSERT + " (:uuid_cargo, :atividade, :nome, :salario, :status)", nativeQuery = true)
	void saveProcNative(
	            @Param("uuid_cargo")UUID uuid,
	            @Param("atividade")String atividade,
	            @Param("nome")String nome,
	            @Param("salario")BigDecimal salario,
	            @Param("status")int status
	    );
	
	@Procedure(procedureName = NAME_PROC_INSERT)
	void saveProc(
	            @Param("uuid_cargo")UUID uuid,
	            @Param("atividade")String atividade,
	            @Param("nome")String nome,
	            @Param("salario")BigDecimal salario,
	            @Param("status")int status
	    );
	
	@Query(nativeQuery = true, value = "SELECT * FROM cargos_atv_sl_maior(:sl)")
	List<CargoSalarioProjection> buscarSalarioMaiorAtivo(@Param("sl") BigDecimal salario);
}
