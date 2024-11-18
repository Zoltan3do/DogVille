package manu_barone.DogVille.services;

import manu_barone.DogVille.entities.Utente;
import manu_barone.DogVille.exceptions.NotFoundException;
import manu_barone.DogVille.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo userRepository;

    public Utente findById(UUID id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nessun utente trovato con ID: " + id));
    }

    public Utente findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Nessun utente registrato con questa email"));
    }

}
