package com.AntonchukAlejandro.services.eventos;

import com.AntonchukAlejandro.domain.EventoGastronomico;

import java.util.UUID;

public interface EventosService {
    void inscribirParticipante(UUID idEvento);

     EventoGastronomico crearEvento();
    void listarEventoNoDisponible();
}
