package com.example.accessingdatarest.entity;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "afiliacion")
public class Afiliacion {

    @EmbeddedId
    private AfiliacionKey id;

    private String rol;
    private LocalDate fechaIngreso;

    @ManyToOne
    @MapsId("idPersonaje")
    @JoinColumn(name = "id_personaje")
    private Personaje personaje;

    @ManyToOne
    @MapsId("idOrganizacion")
    @JoinColumn(name = "id_organizacion")
    private Organizacion organizacion;

    // Empty Constructor
    public Afiliacion() {
    }

    // Getters y Setters
    public AfiliacionKey getId() {
        return id;
    }

    public void setId(AfiliacionKey id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

}

