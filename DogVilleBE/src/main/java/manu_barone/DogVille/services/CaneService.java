package manu_barone.DogVille.services;

import manu_barone.DogVille.entities.Cane;
import manu_barone.DogVille.exceptions.NotFoundException;
import manu_barone.DogVille.payloads.CaneDTO;
import manu_barone.DogVille.repositories.CaneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class CaneService {
    @Autowired
    private CaneRepo caneRepo;

    public Page<Cane> findWithFilters(Boolean isAdopted,Integer age, Boolean isWeaned, String race, String healthState, Character gender, String dogSize, Pageable pageable) {
        Specification<Cane> specs = Specification.where((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isAdopted"), false));
        if (age != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age));
        if (isWeaned != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isWeaned"), isWeaned));
        if (race != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("race"), race));
        if (healthState != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("healthState"), healthState));
        if (gender != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("gender"), gender));
        if (dogSize != null) {
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dogSize"), dogSize));
        }
        if (dogSize != null) {
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isAdopted"), isAdopted));
        }
        return caneRepo.findAll(specs, pageable);
    }

    public Cane addCane(CaneDTO body) {
        return caneRepo.save(new Cane(body.name(),
                body.age(),
                body.dogSize(),
                body.race(),
                body.healthState(),
                body.gender().charAt(0),
                body.description(),
                body.isWeaned()));
    }

    public Cane findById(UUID id) {
        return caneRepo.findById(id).orElseThrow(() -> new NotFoundException("Nessun cane trovato con questo ID: " + id));
    }

}
