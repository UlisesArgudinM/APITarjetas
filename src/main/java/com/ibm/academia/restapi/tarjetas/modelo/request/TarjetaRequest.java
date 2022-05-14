package com.ibm.academia.restapi.tarjetas.modelo.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaRequest 
{
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String tuPasion;
	
	@NotNull(message = "No puede estar vacio")
	@Positive(message = "no debe ser salarios negativos")
	private double salarioMensual;
	
	@NotNull(message = "No puede estar vacio")
	@Positive(message = "no debe ser anios negativos")
	private double anio;
}
