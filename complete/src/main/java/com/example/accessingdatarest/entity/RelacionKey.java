package com.example.accessingdatarest.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RelacionKey implements Serializable {
    private Long idPersonajeA;
    private Long idPersonajeB;
    
    public RelacionKey() {
    }

    public RelacionKey(Long idPersonajeA, Long idPersonajeB) {
        this.idPersonajeA = idPersonajeA;
        this.idPersonajeB = idPersonajeB;
    }
    
}
