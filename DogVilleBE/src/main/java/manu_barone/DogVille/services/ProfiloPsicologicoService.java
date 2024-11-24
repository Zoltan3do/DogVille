package manu_barone.DogVille.services;

import jakarta.transaction.Transactional;
import manu_barone.DogVille.entities.ProfiloPsicologico;
import manu_barone.DogVille.payloads.CompatibilitaProfiliDTO;
import manu_barone.DogVille.payloads.ProfiloPsicologicoDTO;
import manu_barone.DogVille.repositories.ProfiloPsicologicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ProfiloPsicologicoService {
    @Autowired
    private ProfiloPsicologicoRepo profiloPsicologicoRepository;

    public ProfiloPsicologico saveProfiloPsicologico(ProfiloPsicologico profiloPsicologico) {
        return profiloPsicologicoRepository.save(profiloPsicologico);
    }

    public List<ProfiloPsicologico> getAllProfiliPsicologici() {
        return profiloPsicologicoRepository.findAll();
    }

    public ProfiloPsicologico getProfiloPsicologicoById(UUID id) {
        return profiloPsicologicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProfiloPsicologico non trovato con ID: " + id));
    }

    @Transactional
    public void saveAllProfilesWithCompatibility(List<CompatibilitaProfiliDTO> profilesData) {
        HashMap<String, ProfiloPsicologico> profileMap = new HashMap<>();

        for (CompatibilitaProfiliDTO data : profilesData) {
            ProfiloPsicologico ownerProfile = profileMap.computeIfAbsent(
                    data.ownerPersonality(),
                    key -> new ProfiloPsicologico(key, data.description())
            );

            for (String compatiblePersonality : data.compatiblePersonalities()) {
                profileMap.computeIfAbsent(
                        compatiblePersonality,
                        key -> new ProfiloPsicologico(key, data.description())
                );
            }
        }

        profiloPsicologicoRepository.saveAll(profileMap.values());

        for (CompatibilitaProfiliDTO data : profilesData) {
            ProfiloPsicologico ownerProfile = profileMap.get(data.ownerPersonality());

            if (ownerProfile != null) {
                for (String compatiblePersonality : data.compatiblePersonalities()) {
                    ProfiloPsicologico compatibleProfile = profileMap.get(compatiblePersonality);

                    if (compatibleProfile != null) {
                        ownerProfile.getCompatibleProfiles().add(compatibleProfile);
                        compatibleProfile.setParentProfile(ownerProfile);
                    }
                }
            }
        }

        profiloPsicologicoRepository.saveAll(profileMap.values());
    }


    public ProfiloPsicologicoDTO toDTO(ProfiloPsicologico profiloPsicologico) {
        System.out.println("Converting profile: " + profiloPsicologico.getType() +
                " with compatible profiles: " + profiloPsicologico.getCompatibleProfiles().stream()
                .map(ProfiloPsicologico::getType)
                .toList());

        return new ProfiloPsicologicoDTO(
                profiloPsicologico.getType(),
                profiloPsicologico.getDescrizione(),
                profiloPsicologico.getCompatibleProfiles().stream()
                        .map(ProfiloPsicologico::getType)
                        .toList()
        );
    }


    public List<ProfiloPsicologicoDTO> getAllProfilesAsDTO() {

        List<ProfiloPsicologico> allProfiles = profiloPsicologicoRepository.findAll();

        allProfiles.forEach(profile -> {
            System.out.println("Profile: " + profile.getType() + " with compatible profiles: " +
                    profile.getCompatibleProfiles().stream()
                            .map(ProfiloPsicologico::getType)
                            .toList());
        });

        return allProfiles.stream()
                .map(this::toDTO)
                .toList();
    }


}
