package com.example.accessingdatarest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatarest.entity.Relacion;
import com.example.accessingdatarest.service.RelacionService;

@RestController
@RequestMapping("/api/relaciones")
public class RelacionController {

    @Autowired
    private RelacionService relacionService;

    @PostMapping("/save")
    public ResponseEntity<Relacion> createRelacion(
            @RequestParam Long idPersonajeA,
            @RequestParam Long idPersonajeB,
            @RequestParam String tipoRelacion) throws URISyntaxException {
        
        relacionService.createRelacion(idPersonajeA, idPersonajeB, tipoRelacion);
        return ResponseEntity.created(new URI("api/relacion/save")).build();
    }

    @GetMapping("/personaje/{idPersonaje}")
    public ResponseEntity<List<Relacion>> getRelacionesByPersonaje(@PathVariable Long idPersonaje) {
        List<Relacion> relaciones = relacionService.getRelacionesByPersonaje(idPersonaje);
        return ResponseEntity.ok(relaciones);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRelacion(
            @RequestParam Long idPersonajeA,
            @RequestParam Long idPersonajeB) {
        
        relacionService.deleteRelacion(idPersonajeA, idPersonajeB);
        return ResponseEntity.noContent().build();
    }
}
