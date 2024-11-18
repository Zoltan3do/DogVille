package manu_barone.DogVille.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "psycologicalProfiles")
@ToString
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"enabled", "accountNonLocked", "credentialsNonExpired", "accountNonExpired", "authorities"})
public class ProfiloPsicologico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String type;

    @ManyToMany(mappedBy = "dogsPsycologicalProfiles")
    @JsonIgnore
    private List<Cane> dogs = new ArrayList<>();

    @ManyToMany(mappedBy = "usersPsycologicalProfiles")
    @JsonIgnore
    private List<Utente> users = new ArrayList<>();


    public ProfiloPsicologico(String type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
