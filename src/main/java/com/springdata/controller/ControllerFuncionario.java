package com.springdata.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdata.projections.FuncionarioProjection;
import com.springdata.service.FuncionarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class ControllerFuncionario {
	
	private final FuncionarioService funcService;
	
	@GetMapping("relatorio/salario")
	public ResponseEntity<List<FuncionarioProjection>> listar() {
		
		return ResponseEntity.ok(funcService.relatorioSalario());
		
	}	
	

}
