package com.AntonchukAlejandro.services.menu.impl;

import com.AntonchukAlejandro.services.eventos.EventosService;
import com.AntonchukAlejandro.services.menu.MenuService;

import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService {
    private EventosService eventosService;



    public MenuServiceImpl(EventosService eventosService) {
        this.eventosService = eventosService;
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
                    break;
                case 4:
                    //dejar resenia

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("\n Aplicacion finalizada");
                default:
                    break;
            }


        }while (opcion != 7);



    }

}
