package com.AntonchukAlejandro.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventoGastronomico {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaYHora;
    private String ubicacion;
    private int capacidad;
    private int participantesActuales;
    private Chef chef;
    private List<Participante> participantes;

    public EventoGastronomico(UUID id, String nombre, String descripcion, LocalDateTime fechaYHora,
                              String ubicacion, int capacidad, Chef chef) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaYHora = fechaYHora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.participantesActuales = 0;
        this.chef = chef;
        this.participantes = new ArrayList<>();
    }

    public EventoGastronomico(UUID id, String nombre, String descripcion, LocalDateTime fechaYHora,
                              String ubicacion, int capacidad) {
        this(id, nombre, descripcion, fechaYHora, ubicacion, capacidad, null);
    }

    public EventoGastronomico() {

    }


    public boolean addParticipantes (Participante participante) {
        if (participantesActuales < capacidad) {
            participantes.add(participante);
            participantesActuales++;
            participante.añadirAsistenciaEvento(this);
            return true;
        }
        return false;
    }













    //getters and setters
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getParticipantesActuales() {
        return participantesActuales;
    }

    public void setParticipantesActuales(int participantesActuales) {
        this.participantesActuales = participantesActuales;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }



}
