package manu_barone.DogVille.payloads;

import jakarta.validation.constraints.*;
import manu_barone.DogVille.entities.enums.StatoSalute;
import manu_barone.DogVille.entities.enums.Taglia;

public record CaneDTO(
        @NotBlank(message = "Il nome del cane non può essere vuoto.")
        @Size(max = 50, message = "Il nome del cane non può superare i 50 caratteri.")
        String name,

        @Min(value = 0, message = "L'età del cane non può essere negativa.")
        @Max(value = 30, message = "L'età del cane non può superare i 30 anni.")
        int age,

        @NotNull(message = "La taglia del cane è obbligatoria.")
        Taglia size,

        @NotBlank(message = "La razza del cane non può essere vuota.")
        @Size(max = 50, message = "La razza del cane non può superare i 50 caratteri.")
        String race,

        @NotNull(message = "Lo stato di salute del cane è obbligatorio.")
        StatoSalute healthState,

        @Pattern(regexp = "[MF]", message = "Il genere del cane deve essere 'M' (Maschio) o 'F' (Femmina).")
        char gender,

        @Size(max = 255, message = "La descrizione del cane non può superare i 255 caratteri.")
        String description,

        boolean isWeaned

) {
}
