package com.proyectalpha.BackEndProyectAlpha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tecnologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnologies;
    private String name;

    public Tecnologies() {
    }

    public Tecnologies(Long idTecnologies, String name) {
        this.idTecnologies = idTecnologies;
        this.name = name;
    }

    public Long getIdTecnologies() {
        return idTecnologies;
    }

    public void setIdTecnologies(Long idTecnologies) {
        this.idTecnologies = idTecnologies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
