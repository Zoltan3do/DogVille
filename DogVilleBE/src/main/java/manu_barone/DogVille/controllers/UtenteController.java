package manu_barone.DogVille.controllers;

import manu_barone.DogVille.entities.Utente;
import manu_barone.DogVille.payloads.UtenteDTO;
import manu_barone.DogVille.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/me")
    public Utente getProfile(@AuthenticationPrincipal Utente currentUtente) {
        return currentUtente;
    }

// DA FINIRE
//    @PutMapping("/me")
//    public Utente updateProfile(@AuthenticationPrincipal Utente currentUtente, @RequestBody @Validated UtenteDTO body) {
//
//        return utenteService.updateUser(currentUtente.getId(), body);
//    }


}
