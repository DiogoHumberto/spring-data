package com.springdata.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.springdata.domain.CargoModel;
import com.springdata.dto.CargoDto;
import com.springdata.service.CargoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("cargos")
@RequiredArgsConstructor
public class ControllerCargo {
	
	private final CargoService cargoService;
	
	@GetMapping
	public ResponseEntity<List<CargoModel>> listar() {
		
		return ResponseEntity.ok(cargoService.listar());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CargoModel> obterPorId(@PathVariable @NotNull UUID id) {
		
		return ResponseEntity.ok(cargoService.obterPorId(id));
		
	}
	
	@PostMapping
	public ResponseEntity<CargoModel> criar(@RequestBody @Valid CargoDto dto, UriComponentsBuilder uriBuilder) {
		
		var respDto = cargoService.criar(dto);
		
		URI uri = uriBuilder.path("/cargo/{id}").buildAndExpand(respDto.getUuid()).toUri();
				
		return ResponseEntity.created(uri).body(respDto);
		
	}
	
	@PutMapping
	public ResponseEntity<CargoModel> alterar(@RequestBody @Valid CargoDto dto, UriComponentsBuilder uriBuilder) {
		
		var respDto = cargoService.alterar(dto);
		
		URI uri = uriBuilder.path("/cargo/{id}").buildAndExpand(respDto.getUuid()).toUri();
				
		return ResponseEntity.created(uri).body(respDto);
		
	}		

}
