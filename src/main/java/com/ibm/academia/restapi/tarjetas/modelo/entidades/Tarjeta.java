package com.ibm.academia.restapi.tarjetas.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tarjetas")
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta implements Serializable 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "tu_Pasion", nullable = false, length = 150)
	private String tuPasion;
	
	@Column(name = "salario_Mensual_Minimo", nullable = false)
	private double salarioMensualMinimo;
	
	@Column(name = "salario_Mensual_Maximo", nullable = false)
	private double salarioMensualMaximo;
	
	@Column(name = "anio_Minimo", nullable = false)
	private double anioMinimo;
	
	@Column(name = "anio_Maximo", nullable = false)
	private double anioMaximo;
	
	@Column(name = "tarjeta_Credito", nullable = false, length = 150)
	private String tarjetaCredito;

	private static final long serialVersionUID = -8801949106521022477L;
}
