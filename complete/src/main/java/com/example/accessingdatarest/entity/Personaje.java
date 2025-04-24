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
@Table(name = "personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonaje;
    
    private String nombre;
    private String origen;
    private String rol;
    private String alineacion;
    
    @OneToMany(mappedBy = "personajeA", cascade = CascadeType.ALL)
    private List<Relacion> relacionesComoA;
    
    @OneToMany(mappedBy = "personajeB", cascade = CascadeType.ALL)
    private List<Relacion> relacionesComoB;
    
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<Afiliacion> afiliaciones;
    
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<UsoTecnologia> tecnologiasUsadas;

    // Empty Constructor
    public Personaje() {
    }

    // Getters and Settters
    public Long getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Long idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public List<Relacion> getRelacionesComoA() {
        return relacionesComoA;
    }

    public void setRelacionesComoA(List<Relacion> relacionesComoA) {
        this.relacionesComoA = relacionesComoA;
    }

    public List<Relacion> getRelacionesComoB() {
        return relacionesComoB;
    }

    public void setRelacionesComoB(List<Relacion> relacionesComoB) {
        this.relacionesComoB = relacionesComoB;
    }

    public List<Afiliacion> getAfiliaciones() {
        return afiliaciones;
    }

    public void setAfiliaciones(List<Afiliacion> afiliaciones) {
        this.afiliaciones = afiliaciones;
    }

    public List<UsoTecnologia> getTecnologiasUsadas() {
        return tecnologiasUsadas;
    }

    public void setTecnologiasUsadas(List<UsoTecnologia> tecnologiasUsadas) {
        this.tecnologiasUsadas = tecnologiasUsadas;
    }
    
    
}
