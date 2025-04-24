package com.example.accessingdatarest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Afiliacion;
import com.example.accessingdatarest.entity.Organizacion;
import com.example.accessingdatarest.entity.Personaje;
import com.example.accessingdatarest.entity.Relacion;
import com.example.accessingdatarest.entity.Tecnologia;
import com.example.accessingdatarest.entity.UsoTecnologia;
import com.example.accessingdatarest.repository.AfiliacionRepository;
import com.example.accessingdatarest.repository.PersonajeRepository;
import com.example.accessingdatarest.repository.RelacionRepository;
import com.example.accessingdatarest.repository.UsoTecnologiaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;
    
    @Autowired
    private RelacionRepository relacionRepository;

    @Autowired
    private UsoTecnologiaRepository usoTecnologiaRepository;

    @Autowired
    private AfiliacionRepository afiliacionRepository;

    // CRUD
    public List<Personaje> findAll(){
        return personajeRepository.findAll();
    }

    public Optional <Personaje> findById(Long id){
        return personajeRepository.findById(id);
    } 

    public void save(Personaje personaje){
        personajeRepository.save(personaje);
    }

    public void update(Long id, Personaje personajeDetails) {
        Personaje personaje = personajeRepository.findById(id).get();
        
        // Personaje personaje = personajeOptional.get();
        personaje.setNombre(personajeDetails.getNombre());
        personaje.setOrigen(personajeDetails.getOrigen());
        personaje.setRol(personajeDetails.getRol());
        personaje.setAlineacion(personajeDetails.getAlineacion());

        personajeRepository.save(personaje);
    }

    public void deleteById(Long id){
        personajeRepository.deleteById(id);
    }

    // Relaciones
    public List<Relacion> getRelaciones(Long idPersonaje){
        return relacionRepository.findByPersonajeA_IdPersonajeOrPersonajeB_IdPersonaje(idPersonaje, idPersonaje);
    }

    public List<Organizacion> getOrganizaciones(Long idPersonaje) {
        return afiliacionRepository.findByPersonajeIdPersonaje(idPersonaje)
            .stream()
            .map(Afiliacion::getOrganizacion)
            .collect(Collectors.toList());
    }

    //public List<Tecnologia> getTecnologias(Long idPersonaje){
    //    return usoTecnologiaRepository.findByIdPersonaje(idPersonaje)
    //        .stream()
    //        .map(UsoTecnologia::getTecnologia)
    //        .collect(Collectors.toList());
    //}
    
}
