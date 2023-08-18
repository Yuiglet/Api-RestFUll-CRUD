package com.example.CRUD.Model;

import jakarta.persistence.*;

@Entity
@Table (name ="Tareas")
public class tasksModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (unique = true)
    private String nomTarea;
    private String descripcionTarea;

    private String estadoTarea;

    public tasksModel() {
    }

    public tasksModel(long id, String nomTarea, String descripcionTarea, String estadoTarea) {
        this.id = id;
        this.nomTarea = nomTarea;
        this.descripcionTarea = descripcionTarea;
        this.estadoTarea = estadoTarea;
    }

    public tasksModel(String nomTarea, String descripcionTarea, String estadoTarea) {
        this.nomTarea = nomTarea;
        this.descripcionTarea = descripcionTarea;
        this.estadoTarea = estadoTarea;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomTarea() {
        return nomTarea;
    }

    public void setNomTarea(String nomTarea) {
        this.nomTarea = nomTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }
}
