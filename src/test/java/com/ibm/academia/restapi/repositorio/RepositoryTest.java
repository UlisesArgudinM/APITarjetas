package com.ibm.academia.restapi.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.restapi.datos.DatosDummy;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;
import com.ibm.academia.restapi.tarjetas.repository.TarjetaRepository;

@DataJpaTest
public class RepositoryTest 
{
	@Autowired
	@Qualifier("repositorioTarjeta")
	private TarjetaRepository tarjetaRepository;
	
	@Test
	@DisplayName("Test: Buscar por tu pasion")
	void buscarxTuPasion()
	{
		List<Tarjeta>listaTarjetas = new ArrayList<Tarjeta>();
		listaTarjetas.add(DatosDummy.tarjeta01());
		listaTarjetas.add(DatosDummy.tarjeta02());
		listaTarjetas.add(DatosDummy.tarjeta03());
		
		Iterable<Tarjeta> tarjetas = tarjetaRepository.saveAll(listaTarjetas);
		
		List<Tarjeta> expected = tarjetaRepository.findByTuPasion("Shopping");
		
		assertThat(expected.size() == 3).isTrue();
	}
	

}
