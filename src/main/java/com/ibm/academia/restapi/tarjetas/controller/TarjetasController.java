package com.ibm.academia.restapi.tarjetas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;
import com.ibm.academia.restapi.tarjetas.modelo.request.TarjetaRequest;
import com.ibm.academia.restapi.tarjetas.services.ITarjetaService;


@RestController
@RequestMapping("/Banco")
@CrossOrigin(origins = "*")
public class TarjetasController 
{

	@Autowired
	ITarjetaService tarjetaService;
	
	/**
	 * Endpoint para visualizar todos los planes de tarjetas
	 * @return retorna todos los planes de tarjetas
	 * @author Usuario 07/05/2022
	 */
	@GetMapping("/TarjetasCredito")
	public ResponseEntity<List<Tarjeta>>obtenerTarjetas()
	{
		List<Tarjeta> tarjetas =tarjetaService.list();
		return new ResponseEntity<List<Tarjeta>>(tarjetas,HttpStatus.OK);
	}
	/**
	 * Endpoint para visualizar las tarjetas del plan encontrado dependiendo de su pasion, edad y salario
	 * @return retorna todas las las tarjetas compatibles con los datos ingresados
	 * @param tarjetaRequest objeto donde guarda informacion recabado por un json
	 * @author Usuario 07/05/2022
	 */
	@PostMapping("/AsignacionTarjeta")
	public ResponseEntity<?>asignacionTarjeta(@Valid @RequestBody TarjetaRequest tarjetaRequest,BindingResult resultado )
	{
		Map<String, Object> validaciones = new HashMap<String, Object>();
		if (resultado.hasErrors())
		{
			List<String> listaErrores = resultado.getFieldErrors()
					.stream()
					.map(errores -> "Campo '" + errores.getField() + "'  " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones,HttpStatus.BAD_REQUEST);
			
		}	
		
		return tarjetaService.tarjetasAceptadas(tarjetaRequest.getTuPasion(), tarjetaRequest.getAnio(), tarjetaRequest.getSalarioMensual());
		
		
	}
}
