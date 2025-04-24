package com.example.accessingdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accessingdatarest.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{
    List<Personaje> findByAlineacion(String alineacion);
}
