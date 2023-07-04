package com.springdata.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdata.service.FuncionarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class ControllerFuncionario {
	
	private final FuncionarioService funcService;
	
	@GetMapping("relatorio/salario")
	public ResponseEntity<Object> listar(@RequestParam(required = false, name = "nome") String nome) {
		
		return ResponseEntity.ok(funcService.relatorioSalario(nome));
		
	}	
	

}
