package com.AntonchukAlejandro.services.organizador.impl;

import com.AntonchukAlejandro.domain.EventoGastronomico;
import com.AntonchukAlejandro.domain.Organizador;
import com.AntonchukAlejandro.services.organizador.OrganizadorService;

import java.util.List;

public class OrganizadorServiceImpl implements OrganizadorService {
    Organizador organizador;

    public OrganizadorServiceImpl(Organizador organizador) {this.organizador = organizador;}

    public List<EventoGastronomico> getEventos() {return this.organizador.getEventos();}
}
