package com.AntonchukAlejandro.domain;

import java.util.UUID;

public class Reseña {
    private UUID id;
    private Integer calificacion;
    private String comentario;
    private EventoGastronomico evento;
    private Participante participante;


    public Reseña(UUID id, Integer calificacion, String comentario) {
        this.id = id;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Reseña() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EventoGastronomico getEvento() {
        return evento;
    }

    public void setEvento(EventoGastronomico evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
