package com.springdata.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springdata.domain.UnidTrabalhoModel;

public interface UnidTrabalhoRepository extends JpaRepository <UnidTrabalhoModel, UUID>{
	
	@Query(nativeQuery=true, value="SELECT *  FROM unid_trabalho ut ORDER BY random() LIMIT :limit")
	List<UnidTrabalhoModel> findRadomUnidTrabLimit(Integer limit);

}
