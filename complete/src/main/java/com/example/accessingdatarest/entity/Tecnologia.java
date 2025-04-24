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
@Table(name = "tecnologia")
public class Tecnologia {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idTecnologia;

    private String nombre;
    private String tipo;
    private String descripcion;

    @OneToMany(mappedBy = "tecnologia", cascade = CascadeType.ALL)
    private List<UsoTecnologia> usos;

    // Empty Constructor
    public Tecnologia() {
    }

    //Getters and Setters
    public Long getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Long idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UsoTecnologia> getUsos() {
        return usos;
    }

    public void setUsos(List<UsoTecnologia> usos) {
        this.usos = usos;
    }    
    
    
}
