package com.AntonchukAlejandro.domain;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id;
    private String nombre;
    private String apellido;
    private List<String> interesCulinario = new ArrayList<>();
    private List<EventoGastronomico> historialEventos = new ArrayList<>();


    public Participante(UUID id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public Participante() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getInteresCulinario() {
        return interesCulinario;
    }


    public List<EventoGastronomico> getHistorialEventos() {
        return historialEventos;
    }

    public List<EventoGastronomico> getHistorialEventosFromId(UUID id){
        if (id.equals(this.id)) {
            return historialEventos;
        }
        return null;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirInteres(String interest) {
        this.interesCulinario.add(interest);
    }

    public void añadirAsistenciaEvento(EventoGastronomico event) {
        this.historialEventos.add(event);
    }
}
