package com.AntonchukAlejandro.services.chef.impl;

import com.AntonchukAlejandro.domain.Chef;
import com.AntonchukAlejandro.services.chef.ChefServices;

import java.util.Scanner;
import java.util.UUID;

public class ChefServicesImpl implements ChefServices {
    public Chef nuevoChef() {
        Chef chef = new Chef();

        Scanner scanner = new Scanner(System.in);

        chef.setId(UUID.randomUUID());

        System.out.println("Ingrese el nombre del participante: ");
        String nombre = scanner.nextLine();
        chef.setNombre(nombre);



        System.out.println("Ingrese la especialidad del chef: ");
        String especialidad = scanner.nextLine();
        chef.setEspecialidad(especialidad);

        return chef;
    }
}
