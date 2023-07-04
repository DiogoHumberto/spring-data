package com.springdata.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.springdata.projections.FuncionarioProjection;

public class FuncionarioSpecification {
	
	public static Specification<FuncionarioProjection> nome(String nome) {
		
		return (root, criteriaQuery, criteriaBuilder) ->
				criteriaBuilder.like(root.get("nome"), "%" + nome + "%");		
	}

}
