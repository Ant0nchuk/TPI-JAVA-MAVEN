package com.AntonchukAlejandro.services.eventos.impl;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.domain.Chef;
import com.AntonchukAlejandro.domain.Participante;
import com.AntonchukAlejandro.services.chef.ChefServices;
import com.AntonchukAlejandro.services.eventos.EventosService;
import com.AntonchukAlejandro.services.organizador.OrganizadorService;
import com.AntonchukAlejandro.services.participante.ParticipanteService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

//Por default este metodo creara un objeto Evento sin un chef a cargo,
//ya que se podra asignarle uno, en la gestion de chefs.

public class EventosServiceImpl implements EventosService {

    private ParticipanteService participanteService;
    private OrganizadorService organizadorService;
    private ChefServices chefService;

    public EventosServiceImpl(ParticipanteService participanteService, OrganizadorService organizadorService,
                              ChefServices chefServices) {
        this.participanteService = participanteService;
        this.organizadorService = organizadorService;
        this.chefService = chefServices;
    }


    public void inscribirParticipante(UUID idEvento) {
        Participante participante = participanteService.nuevoParticipante();
        boolean existeEvento = Boolean.FALSE;

        for (EventoGastronomico evento : organizadorService.getEventos()) {

            if (evento.getId().equals(idEvento))
                //Encontramos el evento
                //participante.getHistorialEventos().add(evento);
                evento.addParticipantes(participante);
            existeEvento = Boolean.TRUE;
            break;
        }
        if (existeEvento) {
            System.out.println("Participante asignado al evento");
        }

    }


    public void inscribirChef(UUID idEvento) {
        Chef chef = chefService.nuevoChef();
        boolean existeEvento = Boolean.FALSE;

        for (EventoGastronomico evento : organizadorService.getEventos()) {

            if (evento.getId().equals(idEvento))
                //Encontramos el evento
                //participante.getHistorialEventos().add(evento);
                evento.setChef(chef);
            existeEvento = Boolean.TRUE;
            break;
        }
        if (existeEvento) {
            System.out.println("Chef asignado al evento");
        }

    }


    public EventoGastronomico crearEvento() {

        EventoGastronomico nuevoEvento = new EventoGastronomico();
        Scanner sc = new Scanner(System.in);

        // Generar un UUID aleatorio
        nuevoEvento.setId(UUID.randomUUID());

        //Solicitar descripcion del evento
        System.out.println("Ingrese el nombre del Evento: ");
        String nombre = sc.nextLine();
        nuevoEvento.setNombre(nombre);


        //Solicitar descripcion del evento
        System.out.println("Ingrese la descripcion del Evento: ");
        String descripcion = sc.nextLine();
        nuevoEvento.setDescripcion(descripcion);


        //solicitar fecha del evento
        System.out.print("Ingrese la fecha del evento (dd/MM/yyyy HH:mm): ");
        String fechaStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
        nuevoEvento.setFechaYHora(fecha);


        //Solicitar la ubicacion
        System.out.println("Ingrese la ubicacion del evento: ");
        String ubicacion = sc.nextLine();
        nuevoEvento.setUbicacion(ubicacion);


        //Solicitar capacidad
        System.out.println("Ingrese la capacidad maxima del evento: ");
        int capacidadMax = sc.nextInt();
        nuevoEvento.setCapacidad(capacidadMax);


        // Lógica de validación
        if (fecha.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha no puede estar en el pasado");
        }


        organizadorService.getEventos().add(nuevoEvento);
        return nuevoEvento;
    }

    public void listarEventoDisponible(LocalDateTime fecha) {
        System.out.println("Listado de eventos");
        for (EventoGastronomico evento : organizadorService.getEventos()) {
            if (evento.getFechaYHora().isAfter(fecha) || evento.getFechaYHora().isEqual(fecha)) {
                System.out.println("Evento " + evento + " disponible");
            }
        }


    }

    public List<EventoGastronomico> listarEventoNoDisponible() {
        List<EventoGastronomico> listaReducida = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fecha: ");
        LocalDateTime fecha = LocalDateTime.now();

        System.out.println("Listado de eventos no disponibles");
        for (EventoGastronomico evento : organizadorService.getEventos()) {
            if (evento.getFechaYHora().isEqual(fecha) && (evento.getCapacidad() == evento.getParticipantesActuales())) {
                listaReducida.add(evento);
                return listaReducida;
                /*String [] datos = {
                        evento.getId().toString(),
                        evento.getNombre(),
                        evento.getDescripcion(),
                        //evento.getFechaYHora.toString(),
                        evento.getUbicacion(),
                        evento.getCapacidad().toString(),*/


            }

        }
        return null;
    }

}

