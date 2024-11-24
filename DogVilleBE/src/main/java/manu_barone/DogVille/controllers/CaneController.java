package manu_barone.DogVille.controllers;

import manu_barone.DogVille.entities.Cane;
import manu_barone.DogVille.exceptions.BadRequestException;
import manu_barone.DogVille.payloads.CaneDTO;
import manu_barone.DogVille.services.CaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cani")
public class CaneController {

    @Autowired
    private CaneService cs;

    @GetMapping
    public Page<Cane> getCani(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "id") String sortBy,
                              @RequestParam(required = false) Integer age,
                              @RequestParam(required = false) Boolean isWeaned,
                              @RequestParam(required = false) String race,
                              @RequestParam(required = false) String healthState,
                              @RequestParam(required = false) Character gender,
                              @RequestParam(required = false) String dogSize,
                              @RequestParam(required = false) Boolean isAdopted

    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return cs.findWithFilters(isAdopted,age, isWeaned, race, healthState, gender, dogSize, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cane saveDog(@RequestBody @Validated CaneDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(". "));
            throw new BadRequestException("Payload error: " + message);
        }
        return cs.addCane(body);
    }

    @GetMapping("/{caneId}")
    public Cane findCaneById(@PathVariable UUID caneId) {
        return cs.findById(caneId);
    }





}
