package com.prenotazioni.progetto20.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewDipendentePayload(
        @NotNull(message = "Il nome è obbligatorio")
        @Size(min = 1, max = 50, message = "Il nome deve essere tra 1 e 50 caratteri")
        String nome,

        @NotNull(message = "Il cognome è obbligatorio")
        @Size(min = 1, max = 50, message = "Il cognome deve essere tra 1 e 50 caratteri")
        String cognome,

        @NotNull(message = "Lo username è obbligatorio")
        @Size(min = 1, max = 50, message = "Lo username deve essere tra 1 e 50 caratteri")
        String username,

        @NotNull(message = "L'email è obbligatoria")
        @Email(message = "L'email deve essere valida")
        String email,

        String immagineProfilo
) {
}
