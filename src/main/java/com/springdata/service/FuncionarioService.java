package com.springdata.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springdata.repository.FuncionarioRepository;
import com.springdata.repository.specification.FuncionarioSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
	
	private final FuncionarioRepository funcRepository;
	
	
	public <T> Object relatorioSalario(String nome){
		
		return nome == null ? funcRepository.findFuncionarioSalario() : funcRepository.findAll(Specification.where(FuncionarioSpecification.nome(nome)));
		
	}



}
