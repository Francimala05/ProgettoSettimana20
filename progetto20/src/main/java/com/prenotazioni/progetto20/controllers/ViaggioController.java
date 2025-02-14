package com.prenotazioni.progetto20.controllers;

import com.prenotazioni.progetto20.entities.Viaggio;
import com.prenotazioni.progetto20.entities.StatoViaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private com.prenotazioni.progetto20.services.ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Optional<Viaggio> getViaggioById(@PathVariable Long id) {
        return viaggioService.getViaggioById(id);
    }

    @PostMapping
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.createViaggio(viaggio);
    }

    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggio) {
        return viaggioService.updateViaggio(id, viaggio);
    }

    @DeleteMapping("/{id}")
    public void deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
    }

    @PutMapping("/{id}/stato")
    public Viaggio changeStatoViaggio(@PathVariable Long id, @RequestBody StatoViaggio stato) {
        return viaggioService.changeStatoViaggio(id, stato);
    }
}
