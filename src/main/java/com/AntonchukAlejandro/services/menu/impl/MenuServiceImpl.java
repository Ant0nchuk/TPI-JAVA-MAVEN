package com.AntonchukAlejandro.services.menu.impl;

import com.AntonchukAlejandro.services.archivo.ArchivoService;
import com.AntonchukAlejandro.services.eventos.EventosService;
import com.AntonchukAlejandro.services.menu.MenuService;
import com.AntonchukAlejandro.services.resenia.ReseniaService;
import com.AntonchukAlejandro.services.resenia.impl.ReseniaServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService {
    private EventosService eventosService;
    private ArchivoService archivoService;
    private ReseniaService reseniaService;


    public MenuServiceImpl(EventosService eventosService, ArchivoService archivoService,
                           ReseniaService reseniaService) {
        this.eventosService = eventosService;
        this.archivoService = archivoService;
        this.reseniaService = reseniaService;
    }

    public void mostrarMenu(Scanner scanner){

        int opcion = 0;


        do {
            System.out.println("---Ingrese Opcion : \n");
            System.out.println("1. Crear Eventos");
            System.out.println("2. Inscribir Participantes");
            System.out.println("3. Gestionar Chefs");
            System.out.println("4. Dejar Reseña Evento");
            System.out.println("5. Listar Eventos");
            System.out.println("6. Exportar Archivo");
            System.out.println("7. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1: //Crear eventos
                    eventosService.crearEvento();
                        //try {
                        //    EventoGastronomico evento = creacionEventos.crearEvento();
                        //    System.out.println("Evento creado: " + evento);
                        //} catch (IllegalArgumentException e) {
                        //    System.err.println("Error: " + e.getMessage());
                        //}
                    break;
                case 2:
                    System.out.println("Ingrese id del curso al cual desea agregar a los participantes: ");
                    String idEvento = scanner.nextLine();

                    System.out.println("Cuantos participantes distintos desea agregar a ese evento?");
                    int cant = scanner.nextInt();
                    for (int i = 0; i < cant; i++) {
                        eventosService.inscribirParticipante(UUID.fromString(idEvento));
                        }
                    break;
                case 3://gestion chefs
                    System.out.println("Ingrese el id del evento al cual quiere inscribir el chef");
                    String idChef = scanner.nextLine();

                    eventosService.inscribirChef(UUID.fromString(idChef));
                    break;
                case 4:
                    System.out.println("Ingrese la id del participante que quiere reseniar: ");
                    String idParticipante = scanner.nextLine();

                    System.out.println("Ingrese la id del evento a reseniar:  ");
                    String idEv = scanner.nextLine();

                    reseniaService.nuevaResenia(UUID.fromString(idParticipante), UUID.fromString(idEv) );
                    break;
                case 5: //listar eventos disponibles
                    System.out.println("Ingrese la fecha a buscar: ");
                    LocalDateTime fecha = LocalDateTime.parse(scanner.nextLine());

                    eventosService.listarEventoDisponible(fecha);
                    break;
                case 6: //Exportar archivo
                    archivoService.exportarEventosCsv(eventosService.listarEventoNoDisponible());
                    break;
                case 7:
                    System.out.println("\n Aplicacion finalizada");
                default:
                    break;
            }


        }while (opcion != 7);



    }

}
