package com.springdata.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface FuncionarioProjection {
	
	String getName();
	String getCpf();
	BigDecimal getSalario();
	Date getDtContratacao();
	

}
