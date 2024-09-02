package com.AntonchukAlejandro.services.eventos;

import com.AntonchukAlejandro.domain.EventoGastronomico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventosService {
    void inscribirParticipante(UUID idEvento);
    void inscribirChef(UUID idEvento);
    EventoGastronomico crearEvento();
    List<EventoGastronomico> listarEventoNoDisponible();
    void listarEventoDisponible(LocalDateTime fecha);
}
