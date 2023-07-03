package com.springdata.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springdata.domain.FuncionarioModel;
import com.springdata.enums.Booleano;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoDto {

//	
//	@NotNull
//	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
//	private Date dtPedido;
		
	private UUID uuid;
	
	@NotBlank
	private String nome;
   
	//@JsonSetter(nulls = Nulls.SKIP)
    @Builder.Default
    private Booleano status = Booleano.SIM;

	private String atividades;
    
	@NotNull
	private BigDecimal salarioBase;

	private List<FuncionarioModel> histCargoFunc;
}
