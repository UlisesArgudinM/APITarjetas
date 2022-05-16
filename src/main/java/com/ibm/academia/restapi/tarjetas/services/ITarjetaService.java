package com.ibm.academia.restapi.tarjetas.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

public interface ITarjetaService
{
	public List<Tarjeta> list();
	public List<Tarjeta> findByTuPasion(String tuPasion);
	public ResponseEntity<?> tarjetasAceptadas(String tuPasion,Double edad,Double salario);
	public boolean existsByTuPasion(String tuPasion);

}
