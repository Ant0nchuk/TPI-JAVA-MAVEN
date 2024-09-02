package com.AntonchukAlejandro.services.archivo.impl;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.services.archivo.ArchivoService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServiceImpl implements ArchivoService {
    private final String UBICACION_ARCHIVO = "\\src\\app\\java\\com\\AntonchukAlejandro\\recursos";

     CSVWriter csvWriter;

    public void exportarEventosCsv(List<EventoGastronomico> eventos){
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("eventos-NO-DISPONIBLES.csv");

        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            //creamos el encabezado
            String[] encabezado = {"LISTADO DE EVENTOS NO DISPONIBLES PARA LA FECHA SELECCIONADA"};
            this.csvWriter.writeNext(encabezado);

            for(EventoGastronomico evento : eventos){
                String[] datos = {
                        evento.getId().toString(),
                        evento.getNombre(),
                        evento.getDescripcion(),
                        evento.getUbicacion(),
                        evento.getCapacidad().toString()
                };
                this.csvWriter.writeNext(datos);
            }
            System.out.println("Exportacion Exitosa");
        }catch(IOException e){
            System.out.println("Algo salio mal, motivo: " + e.getMessage().concat("Ubicacion archivo : " + ruta));
        }
    }

    public void cerrarWriter() {
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }
    }

}
