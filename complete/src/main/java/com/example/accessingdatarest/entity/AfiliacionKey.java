package com.example.accessingdatarest.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class AfiliacionKey implements Serializable{
    private Long idPersonaje;
    private Long idOrganizacion;
    
    public AfiliacionKey() {
    }

    public AfiliacionKey(Long idPersonaje, Long idOrganizacion) {
        this.idPersonaje = idPersonaje;
        this.idOrganizacion = idOrganizacion;
    }
    
}
