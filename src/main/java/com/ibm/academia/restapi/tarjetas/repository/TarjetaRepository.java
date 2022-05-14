package com.ibm.academia.restapi.tarjetas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>
{
	List<Tarjeta> findByTuPasion(String tuPasion);
	boolean existsByTuPasion(String tuPasion);
}
