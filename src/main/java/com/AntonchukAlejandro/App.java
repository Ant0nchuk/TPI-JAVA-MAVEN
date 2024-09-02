package com.AntonchukAlejandro;


import com.AntonchukAlejandro.domain.Organizador;
import com.AntonchukAlejandro.services.archivo.ArchivoService;
import com.AntonchukAlejandro.services.archivo.impl.ArchivoServiceImpl;
import com.AntonchukAlejandro.services.organizador.impl.OrganizadorServiceImpl;
import com.AntonchukAlejandro.services.participante.impl.ParticipanteServiceImpl;
import com.AntonchukAlejandro.services.chef.ChefServices;
import com.AntonchukAlejandro.services.chef.impl.ChefServicesImpl;
import com.AntonchukAlejandro.services.eventos.EventosService;
import com.AntonchukAlejandro.services.eventos.impl.EventosServiceImpl;
import com.AntonchukAlejandro.services.menu.impl.MenuServiceImpl;
import com.AntonchukAlejandro.services.organizador.OrganizadorService;
import com.AntonchukAlejandro.services.participante.ParticipanteService;
import com.AntonchukAlejandro.services.resenia.ReseniaService;
import com.AntonchukAlejandro.services.resenia.impl.ReseniaServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Organizador organizador = new Organizador();
        ParticipanteService participanteService = new ParticipanteServiceImpl();
        OrganizadorService organizadorService = new OrganizadorServiceImpl(organizador);
        ArchivoService archivoService  = new ArchivoServiceImpl();
        ReseniaService reseniaService = new ReseniaServiceImpl(null,null);

        ChefServices chefService = new ChefServicesImpl();
        EventosService eventosService = new EventosServiceImpl(participanteService, organizadorService, chefService);
        MenuServiceImpl menuServiceImpl = new MenuServiceImpl(eventosService, archivoService, reseniaService);
        Scanner scanner = new Scanner(System.in);

        menuServiceImpl.mostrarMenu(scanner);

        scanner.close();
        archivoService.cerrarWriter();

    }
}