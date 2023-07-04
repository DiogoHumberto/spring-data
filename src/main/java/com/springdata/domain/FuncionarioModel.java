package com.springdata.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import com.springdata.converters.BooleanoAttributeConverter;
import com.springdata.enums.Booleano;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "funcionario")
public class FuncionarioModel {
	
	@Id
	@Column(name = "uuid_funcionario")
	@GeneratedValue
    @UuidGenerator(style = Style.TIME)
	private UUID uuid;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "salario")
	private BigDecimal salario;
	
	@Column(name = "dt_contratacao")
	private Date dtContratacao;
	
    @Convert(converter = BooleanoAttributeConverter.class)
    @Column(name = "status")
    @Builder.Default
    private Booleano status = Booleano.SIM;
	
	@JoinColumn(name = "uuid_cargo")
	@ManyToOne
	private CargoModel cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "funcionarios_unidades", joinColumns = {
			@JoinColumn(name = "uuid_funcionario") }, 
	inverseJoinColumns = { @JoinColumn(name = "uuid_unid") })
	private List<UnidTrabalhoModel> unidadeTrabalhos;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "hist_cargo_func", joinColumns = @JoinColumn(name = "uuid_funcionario"), 
	inverseJoinColumns = @JoinColumn(name = "uuid_cargo"))
	private List<CargoModel> histCargoFunc;

}
