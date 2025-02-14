package com.prenotazioni.progetto20.services;

import com.prenotazioni.progetto20.entities.StatoViaggio;
import com.prenotazioni.progetto20.entities.Viaggio;
import com.prenotazioni.progetto20.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Optional<Viaggio> getViaggioById(Long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Viaggio updateViaggio(Long id, Viaggio viaggio) {
        if (viaggioRepository.existsById(id)) {
            viaggio.setId(id);
            return viaggioRepository.save(viaggio);
        }
        return null;
    }

    public void deleteViaggio(Long id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio changeStatoViaggio(Long id, StatoViaggio stato) {
        Optional<Viaggio> viaggio = viaggioRepository.findById(id);
        if (viaggio.isPresent()) {
            viaggio.get().setStato(stato);
            return viaggioRepository.save(viaggio.get());
        }
        return null;
    }
}
