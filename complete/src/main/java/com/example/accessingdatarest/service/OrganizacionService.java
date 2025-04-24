package com.example.accessingdatarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Organizacion;
import com.example.accessingdatarest.repository.AfiliacionRepository;
import com.example.accessingdatarest.repository.OrganizacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrganizacionService {
    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private AfiliacionRepository afiliacionRepository;

    // CRUD
    public List<Organizacion> findAll(){
        return organizacionRepository.findAll();
    }

    public Optional <Organizacion> findById(Long idOrganization){
        return organizacionRepository.findById(idOrganization);
    }

    public void save(Organizacion organizacion){
        organizacionRepository.save(organizacion);
    }

    public void update(Long idOrganizacion, Organizacion organizacionDetails) {
        Organizacion org = organizacionRepository.findById(idOrganizacion).get();
        
        // Personaje personaje = personajeOptional.get();
        org.setNombre(organizacionDetails.getNombre());
        org.setCiudadBase(organizacionDetails.getCiudadBase());
        org.setTipo(organizacionDetails.getTipo());

        organizacionRepository.save(org);
    }

    public void deleteOrganizacion(Long idOrganizacion){
        // Primero eliminamos las afiliaciones para evitar problemas de FK
        afiliacionRepository.deleteByOrganizationId(idOrganizacion);
        organizacionRepository.deleteById(idOrganizacion);
    }

    // Métodos personalizados
    public List<Organizacion> getOrganizationsByTipo(String tipo) {
        return organizacionRepository.findByTipo(tipo);
    }

    public List<Organizacion> getOrganizationsWithMinMembers(int minMembers) {
        return organizacionRepository.findByMinMiembros(minMembers);
    }

}
