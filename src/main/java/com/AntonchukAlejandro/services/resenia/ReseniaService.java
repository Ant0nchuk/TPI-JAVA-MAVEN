package com.AntonchukAlejandro.services.resenia;

import com.AntonchukAlejandro.domain.Reseña;

import java.util.UUID;

public interface ReseniaService{
    Reseña nuevaResenia(UUID idParticipante, UUID idEvento);
}
