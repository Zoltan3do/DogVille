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

    public Page<Cane> findWithFilters(Integer age, Boolean isWeaned, String race, String healthState, Character gender, String size, Pageable pageable) {
        Specification<Cane> specs = Specification.where(null);
        if (age != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age));
        if (isWeaned != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isWeaning"), isWeaned));
        if (race != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("race"), race));
        if (healthState != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("healthState"), healthState));
        if (gender != null)
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("gender"), gender));
        if (size != null) {
            specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("size"), size));
        }
        return caneRepo.findAll(specs, pageable);
    }

    public Cane addCane(CaneDTO body) {
        return new Cane(body.name(),
                body.age(),
                body.size(),
                body.race(),
                body.healthState(),
                body.gender(),
                body.description(),
                body.isWeaned());
    }

    public Cane findById(UUID id) {
        return caneRepo.findById(id).orElseThrow(() -> new NotFoundException("Nessun cane trovato con questo ID: " + id));
    }

}
