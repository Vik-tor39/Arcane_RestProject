package com.example.accessingdatarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Personaje;
import com.example.accessingdatarest.entity.Relacion;
import com.example.accessingdatarest.entity.RelacionKey;
import com.example.accessingdatarest.repository.PersonajeRepository;
import com.example.accessingdatarest.repository.RelacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RelacionService {
    @Autowired
    private RelacionRepository relacionRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    //Create Relacion
    public void createRelacion(Long idPersonajeA, Long idPersonajeB, String tipoRelacion){
        Personaje personajeA = personajeRepository.findById(idPersonajeA).get();
        Personaje personajeB = personajeRepository.findById(idPersonajeB).get();

        RelacionKey key = new RelacionKey(idPersonajeA, idPersonajeB);
        Relacion relacion = new Relacion();
        relacion.setId(key);
        relacion.setPersonajeA(personajeA);
        relacion.setPersonajeB(personajeB);
        relacion.setTipoRelacion(tipoRelacion);

        relacionRepository.save(relacion);
    }

    public List<Relacion> getRelacionesByPersonaje(Long id){
        return relacionRepository.findByPersonajeA_IdPersonajeOrPersonajeB_IdPersonaje(id, id);
    }

    // DELETE
    public void deleteRelacion(Long idPersonajeA, Long idPersonajeB) {
        RelacionKey key = new RelacionKey(idPersonajeA, idPersonajeB);
        relacionRepository.deleteById(key);
    }
}
