package com.AntonchukAlejandro.domain;

import java.util.ArrayList;
import java.util.List;

public class Organizador {
    private List<EventoGastronomico> eventos = new ArrayList<>();

    public List<EventoGastronomico> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }
}
