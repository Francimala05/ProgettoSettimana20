package com.prenotazioni.progetto20.payloads;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record NewViaggioPayload(
        @NotNull(message = "La data del viaggio è obbligatoria")
        LocalDate data,

        @NotNull(message = "La destinazione è obbligatoria")
        String destinazione,

        @NotNull(message = "Lo stato del viaggio è obbligatorio")
        String stato
) {
}
