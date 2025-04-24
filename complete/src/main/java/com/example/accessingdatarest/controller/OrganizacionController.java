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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatarest.entity.Organizacion;
import com.example.accessingdatarest.service.OrganizacionService;

@RestController
@RequestMapping("api/organizacion")
public class OrganizacionController {
    @Autowired
    private OrganizacionService organizacionService;

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllOrganizaciones() {
        List<Organizacion> organizacions = organizacionService.findAll();
        if (organizacions.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        return ResponseEntity.ok(organizacions);
    }

    @GetMapping("/{id}/find")
    public ResponseEntity<?> getPersonajeById(@PathVariable Long id) {
        return organizacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<?> createOrganizacion(@RequestBody Organizacion organizacion) throws URISyntaxException {
        organizacionService.save(organizacion);
        return ResponseEntity.created(new URI("api/organizacion/save")).build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateOrganizacion(@PathVariable Long id, @RequestBody Organizacion organizacionDetails){
        Optional<Organizacion> optionalOrganizacion = organizacionService.findById(id);
        if (optionalOrganizacion.isPresent()){
            organizacionService.update(id, organizacionDetails);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteOrganizacion(@PathVariable Long id){
        Optional<Organizacion> optionalOrganizacion = organizacionService.findById(id);
        if (optionalOrganizacion.isPresent()){
            organizacionService.deleteOrganizacion(id);;
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> getOrganizacionByTipo(@PathVariable String tipo) {
        List<Organizacion> organizations = organizacionService.getOrganizationsByTipo(tipo);
        return ResponseEntity.ok(organizations);
    }

    @GetMapping("/min-miembros")
    public ResponseEntity<?> getOrganizationsWithMinMembers(
            @RequestParam(defaultValue = "1") int minMembers) {
        List<Organizacion> organizations = organizacionService.getOrganizationsWithMinMembers(minMembers);
        return ResponseEntity.ok(organizations);
    }
}
