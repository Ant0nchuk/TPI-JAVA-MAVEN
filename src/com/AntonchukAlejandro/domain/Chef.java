package com.AntonchukAlejandro.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {
    private UUID id;
    private String nombre;
    private String especialidad;
    private List<EventoGastronomico> eventos = new ArrayList<>();

    public Chef(UUID id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Chef() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<EventoGastronomico> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }
}
