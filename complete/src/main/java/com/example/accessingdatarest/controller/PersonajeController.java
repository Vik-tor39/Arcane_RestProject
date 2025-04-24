package com.example.accessingdatarest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatarest.entity.Organizacion;
import com.example.accessingdatarest.entity.Personaje;
import com.example.accessingdatarest.entity.Relacion;
import com.example.accessingdatarest.entity.Tecnologia;
import com.example.accessingdatarest.service.PersonajeService;

@RestController
@RequestMapping("api/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/findAll")
    public ResponseEntity<?> getAllPersonajes() {
        List<Personaje> personajes = personajeService.findAll();
        if (personajes.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        return ResponseEntity.ok(personajes);
    }
    
    @GetMapping("/{id}/find")
    public ResponseEntity<?> getPersonajeById(@PathVariable Long id) {
        return personajeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> createPersonaje(@RequestBody Personaje personaje) throws URISyntaxException {
        personajeService.save(personaje);
        return ResponseEntity.created(new URI("api/personajes/save")).build();
    }
    
    @PutMapping("/{idPersonaje}/update")
    public ResponseEntity<?> updatePersonaje(@PathVariable Long idPersonaje, @RequestBody Personaje personajeDetails){
        Optional<Personaje> optionalPersonaje = personajeService.findById(idPersonaje);
        if (optionalPersonaje.isPresent()){
            personajeService.update(idPersonaje, personajeDetails);
            return ResponseEntity.ok("Registro Actualizado");
        } 
        return ResponseEntity.notFound().build();
    } 

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
        Optional<Personaje> optionalPersonaje = personajeService.findById(id);
        if (optionalPersonaje.isPresent()){
            personajeService.deleteById(id);;
            return ResponseEntity.ok("Registro Eliminado");
        } 
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/relaciones")
    public List<Relacion> getRelaciones(@PathVariable Long id) {
        return personajeService.getRelaciones(id);
    }
    
    // @GetMapping("/{id}/tecnologias")
    // public List<Tecnologia> getTecnologias(@PathVariable Long id) {
    //     return personajeService.getTecnologias(id);
    // }

    @GetMapping("/{id}/organizaciones")
    public List<Organizacion> getOrganizacions(@PathVariable Long id){
        return personajeService.getOrganizaciones(id);
    }
}
