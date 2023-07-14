package com.springdata.controller;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdata.service.GeneratedDataService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("auto-gereted")
@RequiredArgsConstructor
public class ControllerAutoGereted {
	
	private final GeneratedDataService generatedDataService;
	
	
	@PostMapping("/async/cargos")
	public ResponseEntity<?> asyncGerarCargos(@RequestParam(required = true, name = "qtd-thread1") Integer th1,
			@RequestParam(required = false, name = "qtd-thread2") Integer th2,
			@RequestParam(required = false, name = "qtd-thread3") Integer th3){
		
		generatedDataService.asyncMultiTreadAutoGeneratedCargos(th1);
		
		if (th2 != null) {
			generatedDataService.asyncMultiTreadAutoGeneratedCargos(th2);
		}
		
		if (th3 != null) {
			generatedDataService.asyncMultiTreadAutoGeneratedCargos(th3);
		}
		
		return ResponseEntity.ok(Collections.singletonMap("ok", true));
		
	}
	
	@PostMapping("/cargos")
	public ResponseEntity<?> gerarCargos(@RequestParam(required = true, name = "qtd") Integer qtd){
				
		return ResponseEntity.ok(generatedDataService.autoGeneratedCargos(qtd));
		
	}
	
	@PostMapping("/unid-trabalho")
	public ResponseEntity<?> gerarUnidTrabalho(@RequestParam(required = true, name = "qtd") Integer qtd){
				
		return ResponseEntity.ok(generatedDataService.autoGeneratedUnidTrabalho(qtd));
		
	}
	
	@PostMapping("/funcionarios")
	public ResponseEntity<?> gerarFuncionarios(@RequestParam(required = true, name = "qtd") Integer qtd){
				
		return ResponseEntity.ok(generatedDataService.autoGeneratedFuncionario(qtd));
		
	}

}
