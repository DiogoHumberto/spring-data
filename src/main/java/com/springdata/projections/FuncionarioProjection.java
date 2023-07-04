package com.springdata.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface FuncionarioProjection {
	
	String getNome();
	String getCpf();
	BigDecimal getSalario();
	Date getDt_contratacao();
	

}
