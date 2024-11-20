package manu_barone.DogVille.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UtenteDTO(
        @NotEmpty(message = "Il nome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il nome deve essere compreso tra 2 e 40 caratteri!")
        String nome,
        @NotEmpty(message = "Il cognome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il cognome deve essere compreso tra 2 e 40 caratteri!")
        String cognome,
        @NotEmpty(message = "Lo username è obbligatorio!")
        @Email(message = "L'email inserita non è un'email valida!")
        @Size(min = 4, message = "La email deve avere almeno 4 caratteri!")
        String email,
        @NotEmpty(message = "password vuota")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "La password non segue i criteri comuni")
        String password,
        @NotEmpty(message = "L'indirizzo è obbligatorio!")
        @Size(min = 4, message = "L'indirizzo deve avere almeno 4 caratteri!")
        String address,
        @NotEmpty
        String telephoneNumber
) {
}
