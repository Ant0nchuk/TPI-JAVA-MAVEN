package com.AntonchukAlejandro.services.resenia.impl;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.domain.Reseña;
import com.AntonchukAlejandro.services.eventos.EventosService;
import com.AntonchukAlejandro.services.participante.ParticipanteService;
import com.AntonchukAlejandro.services.resenia.ReseniaService;

import java.util.Scanner;
import java.util.UUID;

public class ReseniaServiceImpl implements ReseniaService {
    private ParticipanteService participanteService;
    private EventosService eventosService;

    public ReseniaServiceImpl(ParticipanteService participanteService, EventosService eventosService) {
        this.participanteService = participanteService;
        this.eventosService = eventosService;
    }

    public Reseña nuevaResenia(UUID idParticipante, UUID idEvento){
        Reseña resenia = new Reseña();
        Scanner scanner = new Scanner(System.in);

        resenia.setId(UUID.randomUUID());

        System.out.println("Ingrese un comentario: ");
        String comentario = scanner.nextLine();
        resenia.setComentario(comentario);

        System.out.println("Ingrese una calificacion del 1 al 5: ");
        int calificacion = scanner.nextInt();
        resenia.setCalificacion(calificacion);

        for (EventoGastronomico event : participanteService.getHistorialEventosFromId(idParticipante)){
            if (event.getId().equals(idEvento))
                resenia.setEvento(event);

        }


        return resenia;
    }
}
