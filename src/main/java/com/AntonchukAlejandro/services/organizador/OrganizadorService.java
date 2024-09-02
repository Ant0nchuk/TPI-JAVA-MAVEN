package com.AntonchukAlejandro.services.organizador;

import com.AntonchukAlejandro.domain.EventoGastronomico;

import java.util.List;

public interface OrganizadorService {
    List<EventoGastronomico> getEventos();
}
