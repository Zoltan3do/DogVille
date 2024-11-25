package manu_barone.DogVille.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import manu_barone.DogVille.entities.Cane;
import manu_barone.DogVille.entities.Utente;
import manu_barone.DogVille.payloads.validationGroups.Create;

import java.util.UUID;

public record AdoptionDTO(
        @NotNull(message = "Questo utente è null",groups = Create.class)
        UUID caneId,
        @NotEmpty(message = "Lo username è obbligatorio!", groups = Create.class)
        @Email(message = "L'email inserita non è un'email valida!")
        @Size(min = 4, message = "La email deve avere almeno 4 caratteri!")
        String userEmail
) {
}
