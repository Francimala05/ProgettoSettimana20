package com.prenotazioni.progetto20.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.prenotazioni.progetto20.entities.Dipendente;
import com.prenotazioni.progetto20.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            var uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");

            Dipendente dipendente = dipendenteService.updateImageProfile(id, imageUrl);

            if (dipendente != null) {
                return ResponseEntity.ok("Immagine caricata con successo!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dipendente non trovato.");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento dell'immagine.");
        }
    }

    @PostMapping("/{dipendenteId}/assegna/{viaggioId}")
    public String assignDipendenteToViaggio(@PathVariable Long dipendenteId, @PathVariable Long viaggioId) {
        if (dipendenteService.assignDipendenteToViaggio(dipendenteId, viaggioId) != null) {
            return "Dipendente assegnato al viaggio con successo!";
        }
        return "Errore nell'assegnazione del dipendente.";
    }
}
