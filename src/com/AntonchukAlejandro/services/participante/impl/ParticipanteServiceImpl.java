package com.AntonchukAlejandro.services.participante.impl;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.domain.Participante;
import com.AntonchukAlejandro.services.participante.ParticipanteService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ParticipanteServiceImpl implements ParticipanteService {
    Participante participante;

    public Participante nuevoParticipante() {
        Participante participante = new Participante();
        Scanner scanner = new Scanner(System.in);

        participante.setId(UUID.randomUUID());

        System.out.println("Ingrese el nombre del participante: ");
        String nombre = scanner.nextLine();
        participante.setNombre(nombre);

        System.out.println("Ingrese el apellido del participante: ");
        String apellido = scanner.nextLine();
        participante.setApellido(apellido);

        //hacer bucle for
        System.out.println("Ingrese el gusto culinario del participante: ");
        String gusto = scanner.nextLine();
        participante.añadirInteres(gusto);

        return participante;
    }

    public List<EventoGastronomico> getEventos() {
        return this.participante.getHistorialEventos();
    }

    public List<EventoGastronomico> getHistorialEventosFromId(UUID id){
        if (id.equals(this.participante.getId())) {
            return this.participante.getHistorialEventos();
        }
        return null;
    }
    //private ParticipanteService participanteService;
    //private EventosService eventosService;

    //public ParticipanteServiceImpl(ParticipanteService participanteService, EventosService eventosService) {
    //   this.participanteService = participanteService;
    //   this.eventosService = eventosService;
}
