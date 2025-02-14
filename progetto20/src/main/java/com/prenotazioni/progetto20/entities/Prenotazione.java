package com.prenotazioni.progetto20.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@ToString
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_richiesta;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    public LocalDate getData_richiesta() {
        return data_richiesta;
    }

    public void setData_richiesta(LocalDate data_richiesta) {
        this.data_richiesta = data_richiesta;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public static boolean isDataPrenotata(Dipendente dipendente, LocalDate data) {
        for (Prenotazione prenotazione : dipendente.getPrenotazioni()) {
            if (prenotazione.getData_richiesta().equals(data)) {
                return true;
            }
        }
        return false;
    }

}
