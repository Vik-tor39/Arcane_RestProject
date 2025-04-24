package com.example.accessingdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.accessingdatarest.entity.Organizacion;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long>{
    List<Organizacion> findByTipo(String tipo);
    
    List<Organizacion> findByCiudadBase(String ciudadBase);
    
    @Query("SELECT o FROM Organizacion o WHERE SIZE(o.miembros) > :minMiembros")
    List<Organizacion> findByMinMiembros(@Param("minMiembros") int minMiembros);
}
