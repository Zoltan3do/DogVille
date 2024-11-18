package manu_barone.DogVille.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import manu_barone.DogVille.entities.enums.StatoSalute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dogs")
@ToString
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"enabled", "accountNonLocked", "credentialsNonExpired", "accountNonExpired", "authorities"})
public class Cane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String age;
    private String size;
    private String race;
    private boolean IsAdopted;

    @Enumerated(EnumType.STRING)
    private StatoSalute healthState;

    private char gender;
    private int like_count;
    private String description;
    private boolean IsWeaned;
    private LocalDate insertionDate;
    private String profileImage;

    @ManyToMany(mappedBy = "likes")
    @JsonIgnore
    private List<Utente> likes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dogs_profiles",
            joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "psycological_profile_id")
    )
    private List<ProfiloPsicologico> dogsPsycologicalProfiles = new ArrayList<>();

    public Cane(String name, String age, String size, String race, StatoSalute healthState, char gender, String description, boolean isWeaned) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.race = race;
        this.healthState = healthState;
        this.gender = gender;
        this.description = description;
        IsWeaned = isWeaned;
        this.like_count = 0;
        this.insertionDate = LocalDate.now();
        this.profileImage = "https://ui-avatars.com/api/?name=" + name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getRace() {
        return race;
    }

    public StatoSalute getHealthState() {
        return healthState;
    }

    public char getGender() {
        return gender;
    }

    public int getLike_count() {
        return like_count;
    }

    public String getDescription() {
        return description;
    }

    public boolean isWeaned() {
        return IsWeaned;
    }

    public LocalDate getInsertionDate() {
        return insertionDate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public boolean isAdopted() {
        return IsAdopted;
    }
}
