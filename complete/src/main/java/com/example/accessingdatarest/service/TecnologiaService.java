package com.example.accessingdatarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatarest.entity.Tecnologia;
import com.example.accessingdatarest.repository.TecnologiaRepository;
import com.example.accessingdatarest.repository.UsoTecnologiaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TecnologiaService {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private UsoTecnologiaRepository usoTecnologiaRepository;

    // CRUD
    public List<Tecnologia> findAll(){
        return tecnologiaRepository.findAll();
    }

    public Optional<Tecnologia> findById(Long idTecnologia){
        return tecnologiaRepository.findById(idTecnologia);
    }

    public void save(Tecnologia tecnologia){
        tecnologiaRepository.save(tecnologia);
    }

    public void update(Long idTecnologia, Tecnologia tecnologiaDetails){
        Tecnologia tech = tecnologiaRepository.findById(idTecnologia).get();
        
        tech.setNombre(tecnologiaDetails.getNombre());
        tech.setTipo(tecnologiaDetails.getTipo());
        tech.setDescripcion(tecnologiaDetails.getDescripcion());
    
        tecnologiaRepository.save(tech);
    }

    public void deleteTecnologia(Long idTecnologia){
        // Eliminar primero los usos de la tecnología
        usoTecnologiaRepository.deleteByIdTecnologia(idTecnologia);
        tecnologiaRepository.deleteById(idTecnologia);
    }

    public List<Tecnologia> getTecnologiasByTipo(String tipo) {
        return tecnologiaRepository.findByTipo(tipo);
    }

    public List<Tecnologia> searchTecnologiasByName(String nombre) {
        return tecnologiaRepository.searchByNombre(nombre);
    }
}
