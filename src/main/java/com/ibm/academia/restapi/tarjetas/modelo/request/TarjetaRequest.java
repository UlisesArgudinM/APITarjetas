package com.ibm.academia.restapi.tarjetas.modelo.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

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
	@Positive(message = "No debe ser salarios negativos")
	private Double salarioMensual;
	
	@NotNull(message = "No puede estar vacio")
	@Positive(message = "No debe ser anios negativos")
	@Digits(integer = 2, fraction = 0, message = "No puede haber decimales")
	@Range(min=18,max = 75, message = "Debe ser un rango de edad entre 18-75")
	private Double edad;
}
