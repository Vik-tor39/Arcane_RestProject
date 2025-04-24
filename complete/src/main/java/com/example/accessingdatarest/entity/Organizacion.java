package com.example.accessingdatarest.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizacion")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrganization;
    
    private String nombre;
    private String ciudadBase;
    private String tipo;
    
    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    private List<Afiliacion> miembros;

    public Organizacion() {
    }

    // Getters and Setters
    public Long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(Long idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudadBase() {
        return ciudadBase;
    }

    public void setCiudadBase(String ciudadBase) {
        this.ciudadBase = ciudadBase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Afiliacion> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Afiliacion> miembros) {
        this.miembros = miembros;
    }
    
    
}
