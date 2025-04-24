package com.example.accessingdatarest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatarest.entity.Afiliacion;
import com.example.accessingdatarest.service.AfiliacionService;

@RestController
@RequestMapping("api/afiliacion")
public class AfiliacionController {
    @Autowired
    private AfiliacionService afiliacionService;

    @PostMapping("/save")
    public ResponseEntity<Afiliacion> createAffiliation(
            @RequestParam Long personajeId,
            @RequestParam Long organizationId,
            @RequestParam String rol,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIngreso) throws URISyntaxException {
        
        afiliacionService.createAfiliacion(personajeId, organizationId, rol, fechaIngreso);
        return ResponseEntity.created(new URI("api/afiliacion/save")).build();
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<?> getAffiliationsByOrganization(@PathVariable Long organizationId) {
        List<Afiliacion> affiliations = afiliacionService.getAffiliationsByOrganization(organizationId);
        return ResponseEntity.ok(affiliations);
    }

    @GetMapping("/personaje/{personajeId}")
    public ResponseEntity<?> getAffiliationsByPersonaje(@PathVariable Long personajeId) {
        List<Afiliacion> affiliations = afiliacionService.getAffiliationsByPersonaje(personajeId);
        return ResponseEntity.ok(affiliations);
    }

    @PutMapping("/update-rol")
    public ResponseEntity<?> updateAffiliationRole(
            @RequestParam Long personajeId,
            @RequestParam Long organizationId,
            @RequestParam String newRole) {
        
        afiliacionService.updateAfiliacion(
                personajeId, organizationId, newRole);
        return ResponseEntity.ok("Registro Actualizado");
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAffiliation(
            @RequestParam Long personajeId,
            @RequestParam Long organizationId) {
        
        afiliacionService.deleteAfiliacion(personajeId, organizationId);
        return ResponseEntity.noContent().build();
    }
}
