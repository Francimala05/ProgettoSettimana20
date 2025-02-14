package com.prenotazioni.progetto20.services;

import com.prenotazioni.progetto20.entities.Dipendente;
import com.prenotazioni.progetto20.entities.Viaggio;

import com.prenotazioni.progetto20.repositories.DipendenteRepository;
import com.prenotazioni.progetto20.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Dipendente updateImageProfile(Long dipendenteId, String imageUrl) {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findById(dipendenteId);

        if (dipendenteOpt.isPresent()) {
            Dipendente dipendente = dipendenteOpt.get();
            dipendente.setImmagineProfilo(imageUrl);
            return dipendenteRepository.save(dipendente);
        }

        return null;
    }


    public Dipendente assignDipendenteToViaggio(Long dipendenteId, Long viaggioId) {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findById(dipendenteId);
        Optional<Viaggio> viaggioOpt = viaggioRepository.findById(viaggioId);

        if (dipendenteOpt.isPresent() && viaggioOpt.isPresent()) {
            Dipendente dipendente = dipendenteOpt.get();
            Viaggio viaggio = viaggioOpt.get();
            dipendente.setViaggio(viaggio);
            return dipendenteRepository.save(dipendente);
        }
        return null;
    }
}