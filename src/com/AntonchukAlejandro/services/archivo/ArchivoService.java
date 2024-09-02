package com.AntonchukAlejandro.services.archivo;

import com.AntonchukAlejandro.domain.EventoGastronomico;

import java.util.List;

public interface ArchivoService {
    void exportarEventosCsv(List<EventoGastronomico> eventos);

    void cerrarWriter();
}
