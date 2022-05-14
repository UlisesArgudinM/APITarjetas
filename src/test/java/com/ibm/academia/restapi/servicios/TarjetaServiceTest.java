package com.ibm.academia.restapi.servicios;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.academia.restapi.tarjetas.repository.TarjetaRepository;
import com.ibm.academia.restapi.tarjetas.services.TarjetaService;

@SpringBootTest
public class TarjetaServiceTest 
{
	@MockBean
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	private TarjetaService tarjetaService;
	
	@Test
	void buscarxTuPasion()
	{
		tarjetaService.findByTuPasion(anyString());
		
		verify(tarjetaRepository.findByTuPasion(anyString()));
	}
	
}
