package com.springdata.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springdata.domain.CargoModel;
import com.springdata.dto.CargoDto;
import com.springdata.exception.BadRequestException;
import com.springdata.repository.CargoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CargoService {
	
	private final CargoRepository cargoRepository;

	public List<CargoModel> listar() {
		return cargoRepository.findAll();
	}

	public CargoModel obterPorId(UUID id) {

		return cargoRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("'cargo' não encontrado ou inexistente!"));
	}

	public CargoModel criar(CargoDto dto) {
	
		if(cargoRepository.existsByNome(dto.getNome())){
			throw  new BadRequestException("já existe um 'cargo' com esse nome!");
		}
		
		return cargoRepository.save(CargoModel.builder()
				.nome(dto.getNome())
				.atividades(dto.getAtividades())
				.salarioBase(dto.getSalarioBase())
				.build());

	}

	public CargoModel alterar(CargoDto dto) {
		var cargo = obterPorId(dto.getUuid());
		
		cargo.setNome(dto.getNome());
		cargo.setAtividades(dto.getAtividades());
		cargo.setSalarioBase(dto.getSalarioBase());
		cargo.setStatus(dto.getStatus());
		
		return cargoRepository.save(cargo);
		
	}
	
	public String saveProcNative(CargoDto dto) {
		
		try {	
			log.info("Iniciando 'add_data' em saveProcedure");
			cargoRepository.saveProcNative(UUID.randomUUID(), dto.getAtividades(), dto.getNome(), dto.getSalarioBase(), 1);
			
		}catch (Exception e) {
			log.info("Erro exec proc 'add_data' em saveProcedure");
			return "Erro ao exec proc";
		}
		
		return "Proc exec com sucesso";
		
	}
	
	public String saveProc(CargoDto dto) {
		
		try {	
			log.info("Iniciando 'add_data' em saveProcedure");
			cargoRepository.saveProc(UUID.randomUUID(), dto.getAtividades(), dto.getNome(), dto.getSalarioBase(), 1);
			
		}catch (Exception e) {
			log.info("Erro exec proc 'add_data' em saveProcedure");
			return "Erro ao exec proc";
		}
		
		return "Proc exec com sucesso";
		
	}

}
