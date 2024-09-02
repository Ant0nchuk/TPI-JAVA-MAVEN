package com.AntonchukAlejandro.services.participante;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.domain.Participante;

import java.util.List;
import java.util.UUID;

public interface ParticipanteService {
    Participante nuevoParticipante();
    public List<EventoGastronomico> getHistorialEventosFromId(UUID id);
    List<EventoGastronomico> getEventos();
    }

