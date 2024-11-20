package manu_barone.DogVille.services;

import manu_barone.DogVille.entities.Utente;
import manu_barone.DogVille.exceptions.BadRequestException;
import manu_barone.DogVille.exceptions.NotFoundException;
import manu_barone.DogVille.payloads.UtenteDTO;
import manu_barone.DogVille.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo userRepository;

    @Autowired
    private PasswordEncoder bcrypt;

    public Utente findById(UUID id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nessun utente trovato con ID: " + id));
    }

    public Utente findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Nessun utente registrato con questa email"));
    }

    public Utente save(UtenteDTO body) {
        this.userRepository.findByEmail(body.email()).ifPresent(
                user -> {
                    throw new BadRequestException("Email " + body.email() + " già in uso!");
                }
        );

        Utente newUser = new Utente(body.nome(), body.cognome(), body.email(), bcrypt.encode(body.password()), body.address(), body.telephoneNumber());

        Utente savedUser = this.userRepository.save(newUser);

        return savedUser;
    }
}
