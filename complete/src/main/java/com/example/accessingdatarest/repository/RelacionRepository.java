package com.example.accessingdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.accessingdatarest.entity.Relacion;
import com.example.accessingdatarest.entity.RelacionKey;

@Repository
public interface RelacionRepository extends JpaRepository<Relacion, RelacionKey>{
    List<Relacion> findByPersonajeA_IdPersonajeOrPersonajeB_IdPersonaje(Long idPersonajeA, Long idPersonajeB);

    // Eliminar relaciones de un personaje
    @Modifying
    @Query("DELETE FROM Relacion r WHERE r.personajeA.idPersonaje = :personajeId OR r.personajeB.idPersonaje = :personajeId")
    void deleteByIdPersonaje(@Param("personajeId") Long personajeId);
}
