package com.example.accessingdatarest.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "relacion")
public class Relacion {
    @EmbeddedId
    private RelacionKey id;
    
    private String tipoRelacion;
    
    @ManyToOne
    @MapsId("idPersonajeA")
    @JoinColumn(name = "id_personaje_a")
    private Personaje personajeA;
    
    @ManyToOne
    @MapsId("idPersonajeB")
    @JoinColumn(name = "id_personaje_b")
    private Personaje personajeB;

    // Empty Constructor
    public Relacion() {
    }

    // Getters and Setters
    public RelacionKey getId() {
        return id;
    }

    public void setId(RelacionKey id) {
        this.id = id;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public Personaje getPersonajeA() {
        return personajeA;
    }

    public void setPersonajeA(Personaje personajeA) {
        this.personajeA = personajeA;
    }

    public Personaje getPersonajeB() {
        return personajeB;
    }

    public void setPersonajeB(Personaje personajeB) {
        this.personajeB = personajeB;
    }
    
}
