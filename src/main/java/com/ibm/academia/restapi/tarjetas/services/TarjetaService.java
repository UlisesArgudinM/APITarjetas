package com.ibm.academia.restapi.tarjetas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.tarjetas.repository.TarjetaRepository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.ibm.academia.restapi.tarjetas.exception.BadRequestException;
import com.ibm.academia.restapi.tarjetas.exception.NotFoundException;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

@Service
@Transactional
public class TarjetaService implements ITarjetaService
{
	@Autowired
	TarjetaRepository tarjetaRepository;
	
	@Override
	public List<Tarjeta> list()
	{
		return tarjetaRepository.findAll();
	}
	
	@Override
	 public List<Tarjeta> findByTuPasion(String tuPasion)
	 {
	        return tarjetaRepository.findByTuPasion(tuPasion);
	 }
	
	 @Override
public ResponseEntity<?> tarjetasAceptadas(String tuPasion,Double anio,Double salario)
{
		List<Tarjeta> tarjetas = findByTuPasion(tuPasion);
		List<String>tarjetasAceptadas = new ArrayList<>();
		if(anio<18L || anio>75L) throw new BadRequestException("Anios invalidos");
		if(salario<=7000L) throw new BadRequestException("salario invalido");
			
	if(!tarjetas.isEmpty()) {
		for(Tarjeta tarjeta:tarjetas)
		{
			if(tarjeta.getAnioMinimo()<=anio && tarjeta.getAnioMaximo()>=anio)
			{
				if(tarjeta.getSalarioMensualMinimo()<=salario && tarjeta.getSalarioMensualMaximo()>=salario)
				{
					tarjetasAceptadas.add(tarjeta.getTarjetaCredito());
					return new ResponseEntity<List<String>>(tarjetasAceptadas,HttpStatus.OK);
				}
			}
		}
	}else {
			throw new BadRequestException("Pasion no valida");
		}
	throw new NotFoundException("no se encontro ningun plan concorde a tus datos");
	

}

	    public void save(Tarjeta tarjeta){
	    	tarjetaRepository.save(tarjeta);
	    }

	    public void delete(long id){
	    	tarjetaRepository.deleteById(id);
	    }

	    public boolean existsById(long id){
	        return tarjetaRepository.existsById(id);
	    }

	    public boolean existsByTuPasion(String tuPasion){
	        return tarjetaRepository.existsByTuPasion(tuPasion);
	    }
}
