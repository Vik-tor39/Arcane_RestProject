package com.example.accessingdatarest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Personaje;
import com.example.accessingdatarest.entity.Tecnologia;
import com.example.accessingdatarest.entity.UsoTecnologia;
import com.example.accessingdatarest.entity.UsoTecnologiaKey;
import com.example.accessingdatarest.repository.PersonajeRepository;
import com.example.accessingdatarest.repository.TecnologiaRepository;
import com.example.accessingdatarest.repository.UsoTecnologiaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsoTecnologiaService {
    @Autowired
    private UsoTecnologiaRepository usoTecnologiaRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    //Create
    public void createUsoTecnologia(Long idPersonaje, Long idTecnologia){
        Personaje personaje = personajeRepository.findById(idPersonaje).get();
        Tecnologia tecnologia = tecnologiaRepository.findById(idTecnologia).get();

        UsoTecnologiaKey key = new UsoTecnologiaKey(idPersonaje, idTecnologia);
        UsoTecnologia uso = new UsoTecnologia();
        uso.setId(key);
        uso.setPersonaje(personaje);
        uso.setTecnologia(tecnologia);

        usoTecnologiaRepository.save(uso);
    }

    // public List<Tecnologia> getTecnologiasByPersonaje(Long personajeId) {
    //     return usoTecnologiaRepository.findByIdPersonaje(personajeId)
    //             .stream()
    //             .map(UsoTecnologia::getTecnologia)
    //             .collect(Collectors.toList());
    // }

    // public List<Personaje> getPersonajesByTecnologia(Long tecnologiaId) {
    //     return usoTecnologiaRepository.findByIdTecnologia(tecnologiaId)
    //             .stream()
    //             .map(UsoTecnologia::getPersonaje)
    //             .collect(Collectors.toList());
    // }

    public void deleteUsoTecnologia(Long personajeId, Long tecnologiaId) {
        UsoTecnologiaKey key = new UsoTecnologiaKey(personajeId, tecnologiaId);
        usoTecnologiaRepository.deleteById(key);
    }
}

