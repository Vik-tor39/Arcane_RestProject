package com.example.accessingdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.accessingdatarest.entity.UsoTecnologia;
import com.example.accessingdatarest.entity.UsoTecnologiaKey;

@Repository
public interface UsoTecnologiaRepository extends JpaRepository<UsoTecnologia, UsoTecnologiaKey>{
    
    //List<UsoTecnologia> findByIdPersonaje(Long personajeId);
    
    //List<UsoTecnologia> findByIdTecnologia(Long tecnologiaId);
    
    @Modifying
    @Query("DELETE FROM UsoTecnologia u WHERE u.personaje.idPersonaje = :personajeId")
    void deleteByIdPersonaje(@Param("personajeId") Long personajeId);
    
    @Modifying
    @Query("DELETE FROM UsoTecnologia u WHERE u.tecnologia.idTecnologia = :tecnologiaId")
    void deleteByIdTecnologia(@Param("tecnologiaId") Long tecnologiaId);
}
