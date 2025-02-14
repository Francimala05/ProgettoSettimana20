package com.prenotazioni.progetto20.services;

import com.prenotazioni.progetto20.entities.Dipendente;
import com.prenotazioni.progetto20.entities.Prenotazione;
import com.prenotazioni.progetto20.entities.Viaggio;
import com.prenotazioni.progetto20.repositories.DipendenteRepository;
import com.prenotazioni.progetto20.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public String prenotaViaggio(Dipendente dipendente, LocalDate data, String descrizione, Viaggio viaggio) {
        if (Prenotazione.isDataPrenotata(dipendente, data)) {
            return "Impossibile prenotare, hai già una prenotazione per questa data.";
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData_richiesta(data);
        prenotazione.setDescrizione(descrizione);
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);

        prenotazioneRepository.save(prenotazione);
        return "Prenotazione effettuata con successo!";
    }
}
