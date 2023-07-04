package com.springdata.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springdata.domain.FuncionarioModel;
import com.springdata.projections.FuncionarioProjection;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, UUID>, PagingAndSortingRepository <FuncionarioModel, UUID>{

	@Query(nativeQuery = true, value = "select f.nome, f.cpf, f.salario, f.dt_contratacao  from funcionario f ")
	List<FuncionarioProjection> findFuncionarioSalario();

}
