package com.example.accessingdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.accessingdatarest.entity.Afiliacion;
import com.example.accessingdatarest.entity.AfiliacionKey;

@Repository
public interface AfiliacionRepository extends JpaRepository<Afiliacion, AfiliacionKey>{
    List<Afiliacion> findByOrganizacionIdOrganization(Long organizationId);
    
    List<Afiliacion> findByPersonajeIdPersonaje(Long personajeId);
    
    @Query("SELECT a FROM Afiliacion a WHERE a.organizacion.idOrganization = :orgId AND a.rol = :rol")
    List<Afiliacion> findByOrganizationAndRol(@Param("orgId") Long orgId, 
                                             @Param("rol") String rol);
    
    @Modifying
    @Query("DELETE FROM Afiliacion a WHERE a.organizacion.idOrganization = :orgId")
    void deleteByOrganizationId(@Param("orgId") Long orgId);
    
    @Modifying
    @Query("DELETE FROM Afiliacion a WHERE a.personaje.idPersonaje = :personajeId")
    void deleteByPersonajeId(@Param("personajeId") Long personajeId);
}
