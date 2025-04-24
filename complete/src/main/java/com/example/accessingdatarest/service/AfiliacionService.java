package com.example.accessingdatarest.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Afiliacion;
import com.example.accessingdatarest.entity.AfiliacionKey;
import com.example.accessingdatarest.entity.Organizacion;
import com.example.accessingdatarest.entity.Personaje;
import com.example.accessingdatarest.repository.AfiliacionRepository;
import com.example.accessingdatarest.repository.OrganizacionRepository;
import com.example.accessingdatarest.repository.PersonajeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AfiliacionService {
    @Autowired
    private AfiliacionRepository afiliacionRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private OrganizacionRepository organizacionRepository;

    // Create Afiliacion:
    public void createAfiliacion(Long idPersonaje, Long idOrganization, String rol, LocalDate fechaIngreso){
        Personaje personaje = personajeRepository.findById(idPersonaje).get();
        Organizacion organizacion = organizacionRepository.findById(idOrganization).get();

        AfiliacionKey key = new AfiliacionKey(idPersonaje, idOrganization);
        Afiliacion afiliacion = new Afiliacion();
        afiliacion.setId(key);
        afiliacion.setPersonaje(personaje);
        afiliacion.setOrganizacion(organizacion);
        afiliacion.setRol(rol);
        afiliacion.setFechaIngreso(fechaIngreso); 

        afiliacionRepository.save(afiliacion);
    }

    public List<Afiliacion> getAffiliationsByPersonaje(Long personajeId) {
        return afiliacionRepository.findByPersonajeIdPersonaje(personajeId);
    }

    public List<Afiliacion> getAffiliationsByOrganization(Long organizationId) {
        return afiliacionRepository.findByOrganizacionIdOrganization(organizationId);
    }

    public void updateAfiliacion(Long personajeId, Long organizationId, String newRol){
        AfiliacionKey key = new AfiliacionKey(personajeId, organizationId);
        Afiliacion aff = afiliacionRepository.findById(key).get();
        
        aff.setRol(newRol);
        afiliacionRepository.save(aff);
    }

    public void deleteAfiliacion(Long personajeId, Long organizacionId){
        AfiliacionKey key = new AfiliacionKey(personajeId, organizacionId);
        afiliacionRepository.deleteById(key);
    }
}
