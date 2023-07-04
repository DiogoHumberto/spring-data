package com.springdata.domain;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import com.springdata.converters.BooleanoAttributeConverter;
import com.springdata.enums.Booleano;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo")
public class CargoModel {

	@Id
	@Column(name = "uuid_cargo")
	@GeneratedValue
	@UuidGenerator(style = Style.TIME)
	private UUID uuid;
	
	@Column(name = "nome")
	private String nome;
	
    @Convert(converter = BooleanoAttributeConverter.class)
    @Column(name = "status")
    @Builder.Default
    private Booleano status = Booleano.SIM;

    @Column(name = "atividades")
	private String atividades;
    
    @Column(name = "salario_base")
	private BigDecimal salarioBase;

}