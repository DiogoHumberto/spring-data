package com.springdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdata.projections.FuncionarioProjection;
import com.springdata.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
	
	private final FuncionarioRepository funcRepository;
	
	
	public List<FuncionarioProjection> relatorioSalario(){
		
		return funcRepository.findFuncionarioSalario();
	}



}
